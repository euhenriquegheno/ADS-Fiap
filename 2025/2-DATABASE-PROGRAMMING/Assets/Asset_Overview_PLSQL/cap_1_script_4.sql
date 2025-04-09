--
-- código fonte disponível do arquivo cap_1_script_4.sql
--

set serveroutput on;

DECLARE

v_nr_dia_semana number(2);

BEGIN
	
	select 	to_number( to_char(sysdate, 'D') )
	into 	v_nr_dia_semana
	from	dual;
	
	if v_nr_dia_semana = 1 then
		dbms_output.put_line( 'Estamos em um domingo');
	elsif v_nr_dia_semana = 7 then
		dbms_output.put_line( 'Estamos em um sábado');
	else
		dbms_output.put_line( 'Não estamos em um sábado ou domingo');
	end if;
	
END;
