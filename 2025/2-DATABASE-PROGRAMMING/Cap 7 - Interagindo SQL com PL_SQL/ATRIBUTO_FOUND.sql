-- Script que trabalha com o conceito do atributo de cursor %FOUND
--
SET SERVEROUTPUT ON;

DECLARE
    CURSOR C_VALOR_TOTAL_MEDIA_VENDAS_CLIENTE IS
        SELECT NR_CLIENTE, ROUND(AVG(VL_TOT_PEDIDO), 2) VL_MEDIO_VENDAS
        FROM DB_PEDIDO
        WHERE EXTRACT(YEAR FROM DT_PEDIDO) = EXTRACT(YEAR FROM SYSDATE)
        GROUP BY NR_CLIENTE;

    -- Variável que será usada para armazenar os dados recuperados pelo cursor
    VC_VALOR_TOTAL_VENDAS_CLIENTE C_VALOR_TOTAL_MEDIA_VENDAS_CLIENTE%ROWTYPE;

    -- Variável que irá controlar quantas linhas foram manipuladas
    V_CONTADOR_CURSOR NUMBER := 0;

BEGIN
    OPEN C_VALOR_TOTAL_MEDIA_VENDAS_CLIENTE;

    -- Inicia o loop de processamento
    LOOP
        FETCH C_VALOR_TOTAL_MEDIA_VENDAS_CLIENTE INTO VC_VALOR_TOTAL_VENDAS_CLIENTE;

        -- Verifica se o cursor trouxe um registro (usando %FOUND)
        IF C_VALOR_TOTAL_MEDIA_VENDAS_CLIENTE%FOUND THEN
            -- Para cada cliente selecionado, atualizamos o seu respectivo valor médio de vendas
            UPDATE DB_CLIENTE
            SET VL_MEDIO_COMPRA = VC_VALOR_TOTAL_VENDAS_CLIENTE.VL_MEDIO_VENDAS
            WHERE NR_CLIENTE = VC_VALOR_TOTAL_VENDAS_CLIENTE.NR_CLIENTE;

            -- A cada linha processada, acumulamos o valor na variável V_CONTADOR_CURSOR
            V_CONTADOR_CURSOR := V_CONTADOR_CURSOR + 1;
        ELSE
            -- Caso não tenha registros, sai do loop
            EXIT;
        END IF;
    END LOOP;

    -- Fechamos o cursor para liberar a memória
    CLOSE C_VALOR_TOTAL_MEDIA_VENDAS_CLIENTE;

    -- Atualizamos todas as transações pendentes
    COMMIT;

    -- Exibe o número de linhas processadas
    DBMS_OUTPUT.PUT_LINE('A quantidade de linhas processadas foram: ' || V_CONTADOR_CURSOR);

END;
/