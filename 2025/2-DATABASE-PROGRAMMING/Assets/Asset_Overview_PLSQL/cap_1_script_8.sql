--
-- código fonte disponível no arquivo cap_1_script_8.sql
--
-- Habilita 1.000.000 caracteres para serem exibidos pelo pacote dbms_output
--
set serveroutput on size 1000000;

declare 
	v_nr_estrelas number(1) := 3;	-- cria uma variável numérica e já assume o valor 3
	v_nm_estrelas varchar2(20);		-- cria uma variável do tipo string sem conteúdo (null)
begin
	case when v_nr_estrelas = 1 then
			v_nm_estrelas := 'Cliente iniciante';
		 when v_nr_estrelas = 2 then	
			v_nm_estrelas := 'Cliente ocasional';
		 when v_nr_estrelas = 3 then	
			v_nm_estrelas := 'Cliente frequente';
		 when v_nr_estrelas = 4 then	
			v_nm_estrelas := 'Cliente fiel';
		 when v_nr_estrelas = 5 then	
			v_nm_estrelas := 'Cliente VIP';
		else
			v_nm_estrelas := 'Número de estrelas incorreto';
	end case;
	
	dbms_output.put_line ('A descrição de estrelas do cliente é : ' || v_nm_estrelas );
	
end;

		