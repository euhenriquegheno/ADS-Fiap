-- Script que utiliza o conceito de FOR LOOP
-- com subqueries
SET SERVEROUTPUT ON;

DECLARE

	-- Variável que irá controlar quantas linhas foram manipuladas.
	V_CONTADOR_CURSOR NUMBER := 00;

BEGIN

	-- Perceba que estamos usando o FOR LOOP diretamente
	-- com um subconsulta, eliminando assim a necessidade
	-- de escrita comando CURSOR.
	FOR z IN (
		SELECT 	NR_CLIENTE,
		ROUND(AVG(VL_TOT_PEDIDO),2) VL_MEDIO_VENDAS
		FROM  	DB_PEDIDO
		WHERE 	EXTRACT(YEAR FROM DT_PEDIDO) = EXTRACT(YEAR FROM SYSDATE)
		GROUP 	BY NR_CLIENTE
		)
	LOOP

	 	-- Para cada cliente selecionado, atualizamos o seu respectivo
		-- valor médio de vendas, utilizando como chave o número do cliente.
		UPDATE DB_CLIENTE SET VL_MEDIO_COMPRA = z.VL_MEDIO_VENDAS
		WHERE NR_CLIENTE = z.NR_CLIENTE;

		-- A cada linha processada, acumulamos o valor na variavel v_contador_cursor.
		V_CONTADOR_CURSOR := SQL%ROWCOUNT;

	END LOOP;


	-- Atualizamos todas as transações pendentes.
	COMMIT;

	DBMS_OUTPUT.PUT_LINE('A quantidade de linhas processadas foram: ' || V_CONTADOR_CURSOR);

END;
/