-- O script abaixo calcula o valor do ticket médio de venda de um 
-- determinado funcionário e se o valor for maior do que R$ 350, 
-- adiciona 5% a mais no percentual atual. Em caso negativo, o novo 
-- valor de comissão será gerado de acordo com o ticket médio de venda.
DECLARE
    v_nr_matricula_func_atd     db_pedido.nr_matricula_func_atd%type;
    v_vl_ticket_medio           db_pedido.vl_tot_pedido%type;
	v_vl_perc_comissao			number(1);
BEGIN
    v_nr_matricula_func_atd := &informe_nr_funcionario_loja;
    SELECT  ROUND( AVG(vl_tot_pedido),2)
    INTO    v_vl_ticket_medio
    FROM    db_pedido
    where   to_char(dt_pedido, 'yyyy') = to_char(sysdate, 'yyyy')
    and     nr_matricula_func_atd = v_nr_matricula_func_atd;
    -- Se o valor do ticket médio de venda feito pelo funcionario
    -- for maior do que R$ 350, adicionamos um bônus de 5% a mais na comissão atual do funcionário.
	-- Caso contrario vamos diminuindo o % de comissão conforme o ticket médio vai caindo.
    IF v_vl_ticket_medio > 350 THEN
		v_vl_perc_comissao := 5;
	ELSIF v_vl_ticket_medio > 320 THEN
		v_vl_perc_comissao := 3;
	ELSIF v_vl_ticket_medio > 315 THEN
		v_vl_perc_comissao := 1;
	ELSE
		v_vl_perc_comissao := -2;
    END IF;
	-- comando que adiciona ou diminui o % do valor da comissão do funcionário.
    update db_func_loja set vl_perc_comissao = vl_perc_comissao + v_vl_perc_comissao
    where nr_matricula_func_loja = v_nr_matricula_func_atd;
    commit;
    
END;
/