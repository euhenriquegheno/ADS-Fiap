--
-- código fonte disponível do arquivo cap_1_script_5.sql
--
set serveroutput on;

DECLARE
		
		-- Tipo de tabela PL/SQL para armazenar os IDs das lojas
		TYPE tb_nr_loja IS TABLE OF NUMBER;
		TYPE tb_nr_estoque IS TABLE OF NUMBER INDEX BY BINARY_INTEGER;

		-- Variáveis para armazenar os IDs das lojas e o estoque 
		v_nr_loja tb_nr_loja;
		v_qt_estoque tb_nr_estoque;

		-- Quantidade de ingredientes a serem adicionados (simulando a atualização)
		v_qt_ingredientes NUMBER := 100;

		-- Procedure local para atualizar o estoque
		PROCEDURE prc_atualiza_estoque_loja(p_v_nr_loja IN tb_nr_loja, p_v_qt_ingredientes IN NUMBER) IS
		BEGIN
			FOR i IN p_v_nr_loja.FIRST .. p_v_nr_loja.LAST LOOP
				v_qt_estoque(p_v_nr_loja(i)) := v_qt_estoque(p_v_nr_loja(i)) + p_v_qt_ingredientes;
				DBMS_OUTPUT.PUT_LINE('Estoque atualizado para a loja ID: ' || p_v_nr_loja(i) || ' - Novo estoque: ' || v_qt_estoque(p_v_nr_loja(i)));
			END LOOP;
		END prc_atualiza_estoque_loja;

BEGIN
		-- Simulação de IDs das lojas e estoque inicial
		v_nr_loja := tb_nr_loja(1, 2, 3, 4, 5); -- Simulando 5 lojas com IDs 1 a 5
		v_qt_estoque(1) := 50;
		v_qt_estoque(2) := 60;
		v_qt_estoque(3) := 70;
		v_qt_estoque(4) := 80;
		v_qt_estoque(5) := 90;

		prc_atualiza_estoque_loja(v_nr_loja, v_qt_ingredientes);

END;
