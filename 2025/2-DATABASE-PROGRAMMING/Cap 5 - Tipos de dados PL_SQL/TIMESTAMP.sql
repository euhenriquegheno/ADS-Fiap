-- O script abaixo cria variáveis do tipo TIMESTAMP e atribui valores a essa variáveis.
-- Após isso, os respectivos conteúdos são exibidos.
SET SERVEROUTPUT ON;
DECLARE
    -- Declarando variáveis do tipo TIMESTAMP
    v_inicio TIMESTAMP 	:= TIMESTAMP '2024-11-14 09:00:00.000';
    v_fim TIMESTAMP 	:= TIMESTAMP '2024-11-14 15:30:45.123';
    -- Variável para armazenar a diferença entre os timestamps
    v_diferenca INTERVAL DAY TO SECOND;
BEGIN
    -- Calculando a diferença entre v_fim e v_inicio
    v_diferenca := v_fim - v_inicio;

    -- Exibindo a diferença no formato de dias, horas, minutos e segundos
    dbms_output.put_line('A diferença de tempo é: ' || 
                         EXTRACT(DAY FROM v_diferenca) || ' dias, ' ||
                         EXTRACT(HOUR FROM v_diferenca) || ' horas, ' ||
                         EXTRACT(MINUTE FROM v_diferenca) || ' minutos, ' ||
                         EXTRACT(SECOND FROM v_diferenca) || ' segundos.');
END;