-- O script abaixo trabalha com a instrução FOR LOOP 
-- e exibir 5 formas de pagamento da tabela DB_FORMA_PAGAMENTO do projeto DBurger.
-- Após isso, irá sair do LOOP.
SET SERVEROUTPUT ON;
DECLARE
    V_CONTADOR_TOTAL PLS_INTEGER;
BEGIN
    -- Armazena a quantidade de linhas cadastradas na tabela forma pagto.
    SELECT COUNT(*) INTO V_CONTADOR_TOTAL FROM DB_FORMA_PAGAMENTO;
        
	FOR xpto IN 1..V_CONTADOR_TOTAL
	LOOP
	
      DBMS_OUTPUT.PUT_LINE('Sequência (' || xpto || ')' );  
      
	  EXIT WHEN xpto > 4;
	
    END LOOP;
END;
/