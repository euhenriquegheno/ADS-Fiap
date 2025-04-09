-- O script abaixo crie uma variável do tipo rowid e carrega o rowid
-- do pedido número 10 da loja número 1.
-- Após isso, o conteúdo do ROWID é exibido.
--
SET SERVEROUTPUT ON;
DECLARE 
    V_ROWID ROWID;
    V_NR_LOJA DB_PEDIDO.NR_LOJA%TYPE;
    V_NR_PEDIDO DB_PEDIDO.NR_PEDIDO%TYPE;
    V_NR_CLIENTE DB_PEDIDO.NR_CLIENTE%TYPE;
BEGIN
    SELECT ROWID, NR_LOJA, NR_PEDIDO, NR_CLIENTE
    INTO V_ROWID, V_NR_LOJA, V_NR_PEDIDO, V_NR_CLIENTE
    FROM  DB_PEDIDO
    WHERE NR_LOJA = 1 AND NR_PEDIDO = 10;
    
    dbms_output.put_line('O rowid para pedido número 10 da loja 1 é: ' || v_rowid);
END;