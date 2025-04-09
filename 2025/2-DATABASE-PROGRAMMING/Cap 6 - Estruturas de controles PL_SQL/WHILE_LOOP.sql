-- O script abaixo trabalha com a instrução WHILE LOOP
SET SERVEROUTPUT ON;
DECLARE
    V_CONTADOR PLS_INTEGER := 10;  -- INICIA O CONTADOR
BEGIN
    -- Enquanto o contador for menor ou igual a 10
    WHILE V_CONTADOR > 0 LOOP
		-- EXIBE O CONTEÚDO DO CONTADOR
        DBMS_OUTPUT.PUT_LINE('SEQUÊNCIA (' || V_CONTADOR || ')' );  
        V_CONTADOR := V_CONTADOR - 1;  -- REDUZINDO O VALOR DO CONTADOR
    END LOOP;
END;