-- O script abaixo cria uma variável do tipo BOOLEAN e atribuI valor a essa variável.
-- Após isso, os respectivos conteúdos são exibidos.
--
SET SERVEROUTPUT ON;
DECLARE
    v_aprovado BOOLEAN := TRUE;
BEGIN
    IF v_aprovado THEN
        dbms_output.put_line('Aprovado.');
    ELSE
        dbms_output.put_line('Reprovado.');
    END IF;
END;