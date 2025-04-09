-- O script abaixo crie 2 variáveis do tipo CHAR e LONGRAW atribui valores a essas variáveis.
-- Após isso, os respectivos conteúdos são exibidos.
--
SET SERVEROUTPUT ON;
DECLARE
    v_texto CHAR(17) := 'FIAP DATA SCIENCE';
    v_texto_binario LONG RAW; 
BEGIN
    v_texto_binario := UTL_RAW.CAST_TO_RAW(v_texto);
  
    -- Exibe o conteúdo binário como uma string hexadecimal para visualização
    dbms_output.put_line('Conteúdo binário armazenado: ' || RAWTOHEX(v_texto_binario)
    || chr(13) || 'Conteúdo CHAR: ' || v_texto );
END;