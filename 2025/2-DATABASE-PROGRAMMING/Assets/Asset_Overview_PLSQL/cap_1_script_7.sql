-- Para caso necessite eliminar a tabela utilize o comando 
-- DROP TABLE T_PEDIDO_DB;
CREATE TABLE T_PEDIDO_DB (NR_LOJA NUMBER, NR_PEDIDO NUMBER, NR_CLIENTE NUMBER, DT_PEDIDO DATE, VL_TOT_PEDIDO NUMBER(8,2));
INSERT INTO T_PEDIDO_DB VALUES (1, 10, 1, TO_DATE('11062024','DDMMYYYY'), 1000);
INSERT INTO T_PEDIDO_DB VALUES (1, 11, 7, TO_DATE('11062024','DDMMYYYY'), 500);

--
-- código fonte disponível do arquivo cap_1_script_7.sql
-- O comando abaixo lista todos os pedidos feitos no DBurger no dia 11/06/2024
--
set serveroutput on size 1000000;

DECLARE
	v_nr_loja 		number(5);
	v_nr_pedido 	number;
	v_nr_cliente 	number(10);
	v_vl_tot_pedido	number(10,2);
    CURSOR cPedidoDBurger IS
	SELECT 	nr_loja, nr_pedido, nr_cliente, vl_tot_pedido
	FROM	t_pedido_db
	WHERE	dt_pedido = to_date('11062024','ddmmyyyy');
	
BEGIN
    OPEN cPedidoDBurger;
	LOOP
		-- Abertura do cursor explícito
		FETCH cPedidoDBurger INTO v_nr_loja, v_nr_pedido, v_nr_cliente, v_vl_tot_pedido;
		dbms_output.put_line('Número do pedido: ' || v_nr_pedido || ' da loja: ' || v_nr_loja);
		IF cPedidoDBurger%NOTFOUND THEN
			EXIT;
		END IF;
	END LOOP;
	CLOSE cPedidoDBurger;
END;