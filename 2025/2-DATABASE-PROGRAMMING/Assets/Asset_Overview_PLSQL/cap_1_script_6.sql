-- Para caso necessite eliminar a tabela utilize o comando 
-- DROP TABLE T_FUNC_DB;
CREATE TABLE T_FUNC_DB (CD_FUNC NUMBER, NM_FUNC VARCHAR2(50), VL_SALARIO_BRUTO NUMBER(8,2));
INSERT INTO T_FUNC_DB VALUES (1, 'FABIO POMPOSO', 10000);
INSERT INTO T_FUNC_DB VALUES (2, 'IONE LOREN', 12000);

--
-- código fonte disponível do arquivo cap_1_script_6.sql
-- O comando abaixo aumenta o salário de todos os funcionários em 7%
--
set serveroutput on;

BEGIN

UPDATE T_FUNC_DB SET VL_SALARIO_BRUTO = VL_SALARIO_BRUTO * 1.07;

IF SQL%FOUND THEN
  dbms_output.put_line('Total de funcionários com salário atualizado: ' || SQL%ROWCOUNT);
  COMMIT;
ELSE
  dbms_output.put_line('Não foram encontrados funcionários para atualizar o salário');
END IF;

END;