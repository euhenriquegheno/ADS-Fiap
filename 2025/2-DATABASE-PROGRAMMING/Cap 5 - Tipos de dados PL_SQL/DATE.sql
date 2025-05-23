-- O script abaixo cria uma variável do tipo DATE e atribui o valor a essa variável por meio do comando SELECT... INTO
-- Após isso, os respectivos conteúdos são exibidos.
SET SERVEROUTPUT ON;
DECLARE
	v_data_nascimento db_cli_fisica.dt_nascimento%type;
	v_data_hoje date;
	v_nr_idade PLS_INTEGER;
BEGIN
	SELECT 	DT_NASCIMENTO, SYSDATE,
			TRUNC( MONTHS_BETWEEN ( SYSDATE, DT_NASCIMENTO ) / 12,0)
	INTO	v_data_nascimento, v_data_hoje, v_nr_idade
	FROM	DB_CLI_FISICA
	WHERE 	NR_CLIENTE = 1;
	
	dbms_output.put_line('O cliente número 1 nasceu em ' || v_data_nascimento 
						 || ' e atualmente tem ' || v_nr_idade || ' anos.');
END;