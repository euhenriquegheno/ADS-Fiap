-- O script abaixo trabalha com a instrução FOR LOOP
-- Os valores assumidos foram: 1,2,3 para i
SET SERVEROUTPUT ON;
BEGIN
   FOR i IN 1..5
   LOOP
	dbms_output.put_line('O valor do contador interno é: (' || i || ')' );
   END LOOP;
END;

-- O script abaixo trabalha com a instrução FOR LOOP REVERSE
-- Os valores assumidos foram: 5,4,3,2,1 para i
SET SERVEROUTPUT ON;
BEGIN
   FOR i IN REVERSE 1..5
   LOOP
	dbms_output.put_line('O valor do contador interno é: (' || i || ')' );
   END LOOP;
END;