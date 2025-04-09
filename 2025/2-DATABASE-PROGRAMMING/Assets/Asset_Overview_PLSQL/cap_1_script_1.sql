--
-- código fonte disponível do arquivo cap_1_script_1.sql
-- 
-- habilitar as mensagens pelo pacote dbms_output
set serveroutput on; 

declare 
	v_nr_estrelas number(1) := 3;	-- cria uma variável numérica e já assume o valor 3
	v_nm_estrelas varchar2(20);		-- cria uma variável do tipo string sem conteúdo (null)
begin
	if v_nr_estrelas = 1 then
		v_nm_estrelas := 'Cliente iniciante';
	elsif v_nr_estrelas = 2 then	
		v_nm_estrelas := 'Cliente ocasional';
	elsif v_nr_estrelas = 3 then	
		v_nm_estrelas := 'Cliente frequente';
	elsif v_nr_estrelas = 4 then	
		v_nm_estrelas := 'Cliente fiel';
	elsif v_nr_estrelas = 5 then	
		v_nm_estrelas := 'Cliente VIP';
	else
		v_nm_estrelas := 'Número de estrelas incorreto';
	end if;
	
	dbms_output.put_line ('A descrição de estrelas do cliente é : ' || v_nm_estrelas );
	
end;