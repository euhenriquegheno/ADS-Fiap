-- O script abaixo cria 2 variáveis do tipo CHAR e atribui valores a essas variáveis.
-- Após isso, os respectivos conteúdos são exibidos.
--
SET SERVEROUTPUT ON;
DECLARE
    v_flag_aprovado CHAR(3) := 'SIM';
    v_st_cliente db_cliente.st_cliente%type := 'I';
BEGIN
    dbms_output.put_line(' O status do cliente é(' || v_st_cliente 
    || ') e o status de aprovação é: ' || v_flag_aprovado);
END;