-- Script que utiliza o cursor implicito SQL SQL%ROWCOUNT
-- e permite criar gerenciamento sobre ele.
--
SET SERVEROUTPUT ON;
DECLARE V_QTD_LINHAS_PROCESSADA NUMBER := 00;
BEGIN

    UPDATE DB_CLIENTE SET QT_ESTRELAS = 0
    WHERE NR_CLIENTE < 10;

    V_QTD_LINHAS_PROCESSADA := SQL%ROWCOUNT;
    DBMS_OUTPUT.PUT_LINE( V_QTD_LINHAS_PROCESSADA ||
                          ' CLIENTES FORAM ALTERADOS!');

    -- Descarta todas as alterações, voltando ao estado original.
    ROLLBACK;

END;
/

-- Script que acessa carrega dados do banco de dados
-- para todos os clientes da DBurger, ou seja,
-- utilizamos os comandos OPEN, FETCH e CLOSE.
--
SET SERVEROUTPUT ON;

DECLARE
	CURSOR C_VALOR_TOTAL_MEDIA_VENDAS_CLIENTE IS
    	SELECT NR_CLIENTE, ROUND(AVG(VL_TOT_PEDIDO),2) VL_MEDIO_VENDAS
    	FROM  DB_PEDIDO
    	WHERE EXTRACT(YEAR FROM DT_PEDIDO) = EXTRACT(YEAR FROM SYSDATE)
	GROUP BY NR_CLIENTE;

	-- Variável que irá controlar quantas linhas foram manipuladas.
	V_CONTADOR_CURSOR NUMBER := 00;

BEGIN

	-- Perceba que usando FOR LOOP não é necessário abrir
	-- e selecionar os dados, pois tudo é armazenando dentro
	-- de uma variável interna do comando.
	FOR XPTO IN C_VALOR_TOTAL_MEDIA_VENDAS_CLIENTE
	LOOP
	 	-- Para cada cliente selecionado, atualizamos o seu respectivo
		-- valor médio de vendas, utilizando como chave o número do cliente.
		UPDATE DB_CLIENTE SET VL_MEDIO_COMPRA = XPTO.VL_MEDIO_VENDAS
		WHERE NR_CLIENTE = XPTO.NR_CLIENTE;

		-- A cada linha processada, acumulamos o valor na variavel v_contador_cursor..
		V_CONTADOR_CURSOR := C_VALOR_TOTAL_MEDIA_VENDAS_CLIENTE%ROWCOUNT;

	END LOOP;


	-- Atualizamos todas as transações pendentes.
	COMMIT;

	DBMS_OUTPUT.PUT_LINE('A quantidade de linhas processadas foram: ' || V_CONTADOR_CURSOR);

END;
/

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