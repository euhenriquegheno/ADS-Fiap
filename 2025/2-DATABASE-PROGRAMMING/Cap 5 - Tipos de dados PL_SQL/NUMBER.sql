-- O script abaixo crie 2 variáveis e atribui valores a essas variáveis.
-- Após isso, os respectivos conteúdos são exibidos
SET SERVEROUTPUT ON;
DECLARE
    v_nr_idade_media_cliente NUMBER(3) := 57;
    v_nr_loja db_loja.nr_loja%type := 00;
BEGIN
    dbms_output.put_line('A idade média do cliente da loja(' 
    || v_nr_loja || ')' || ' é: ' || v_nr_idade_media_cliente);
END;