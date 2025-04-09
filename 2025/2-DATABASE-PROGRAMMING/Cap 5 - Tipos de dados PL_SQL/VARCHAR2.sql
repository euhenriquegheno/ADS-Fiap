-- O script abaixo cria 2 variáveis do tipo VARCHAR e VARCHAR2 e atribui valores a essas variáveis.
-- Após isso, os respectivos conteúdos são exibidos.
--
SET SERVEROUTPUT ON;

DECLARE
    v_primeiro_nome VARCHAR2(20) := 'Oivlas';
    v_sobrenome     VARCHAR2(20) := 'Sakspildap';
    v_nome_completo VARCHAR2(40);
BEGIN
    v_nome_completo := v_primeiro_nome || ' ' || v_sobrenome;
    dbms_output.put_line('Nome completo: ' || v_nome_completo);
END;