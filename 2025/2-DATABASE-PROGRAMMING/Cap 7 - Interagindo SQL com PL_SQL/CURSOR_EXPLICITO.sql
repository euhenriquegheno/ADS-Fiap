-- Script que acesso o banco de dados Oracle
-- e armazena no cursor  C_VALOR_TOTAL_MEDIA_VENDAS_CLIENTE
-- o valor médio de vendas durante o ano corrente
-- para todos os clientes da DBurger
SET SERVEROUTPUT ON;

DECLARE
CURSOR C_VALOR_TOTAL_MEDIA_VENDAS_CLIENTE IS
    	SELECT NR_CLIENTE, ROUND(AVG(VL_TOT_PEDIDO),2)
    	FROM 	DB_PEDIDO
    	WHERE EXTRACT(YEAR FROM DT_PEDIDO) = EXTRACT(YEAR FROM SYSDATE)
	GROUP BY NR_CLIENTE;

BEGIN
	NULL; -- Comando utilizado para validar a sintaxe do bloco begin
END;
/

-- Script que acessa o banco de dados Oracle
-- e armazena no cursor  C_VALOR_TOTAL_MEDIA_VENDAS_CLIENTE
-- o valor médio de vendas durante o ano corrente
-- para todos os clientes da DBurger, depois disso
-- abrimos e fechamos o cursor.
SET SERVEROUTPUT ON;

DECLARE
	CURSOR C_VALOR_TOTAL_MEDIA_VENDAS_CLIENTE IS
    SELECT NR_CLIENTE, ROUND(AVG(VL_TOT_PEDIDO),2)
    FROM  DB_PEDIDO
    WHERE EXTRACT(YEAR FROM DT_PEDIDO) = EXTRACT(YEAR FROM SYSDATE)
	GROUP BY NR_CLIENTE;

BEGIN
	OPEN C_VALOR_TOTAL_MEDIA_VENDAS_CLIENTE;
	-- Em breve vamos inserir as regras de negócio para realizar
	-- o processamento

	-- Fechamos o cursor para não deixa-lo aberto na memória do SGBD,
	-- evitando assim existir áreas de memórias inconsistentes.
	CLOSE C_VALOR_TOTAL_MEDIA_VENDAS_CLIENTE;

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

	-- Perceba que criamos a variável VC_VALOR_TOTAL_VENDAS_CLIENTE
	-- que será herdada do tipo cursor.
	VC_VALOR_TOTAL_VENDAS_CLIENTE C_VALOR_TOTAL_MEDIA_VENDAS_CLIENTE%ROWTYPE;

BEGIN
	OPEN C_VALOR_TOTAL_MEDIA_VENDAS_CLIENTE;
	-- Em breve vamos inserir as regras de negócio para realizar
	-- o processamento
	LOOP

		FETCH C_VALOR_TOTAL_MEDIA_VENDAS_CLIENTE
        INTO VC_VALOR_TOTAL_VENDAS_CLIENTE;
		EXIT WHEN C_VALOR_TOTAL_MEDIA_VENDAS_CLIENTE%NOTFOUND;


		-- Para cada cliente selecionado, atualizamos o seu respectivo
		-- valor médio de vendas.
		UPDATE DB_CLIENTE SET VL_MEDIO_COMPRA = VC_VALOR_TOTAL_VENDAS_CLIENTE.VL_MEDIO_VENDAS
		WHERE NR_CLIENTE = VC_VALOR_TOTAL_VENDAS_CLIENTE.NR_CLIENTE;


	END LOOP;

	-- Fechamos o cursor para não deixa-lo aberto na memória do SGBD,
	-- evitando assim existir áreas de memórias inconsistentes.
	CLOSE C_VALOR_TOTAL_MEDIA_VENDAS_CLIENTE;

	-- Atualizamos todas as transações pendentes.
	COMMIT;
END;
/