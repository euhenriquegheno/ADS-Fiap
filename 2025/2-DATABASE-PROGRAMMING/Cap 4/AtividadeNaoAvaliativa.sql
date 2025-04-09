SET SERVEROUTPUT ON;
DECLARE
    v_texto VARCHAR2(200);
    v_qtde_dias_vida number;
    v_nr_cliente db_cliente.nr_cliente%type;
    v_nm_cliente db_cliente.nm_cliente%type;
    v_dt_nascimento db_cli_fisica.dt_nascimento%type;
    v_dia_semana_nascimento varchar2(20) default 'Domingo';
BEGIN
    SELECT cli.nr_cliente, cli.nm_cliente, cfi.dt_nascimento, trunc(sysdate - cfi.dt_nascimento)
    INTO v_nr_cliente, v_nm_cliente, v_dt_nascimento, v_qtde_dias_vida
    FROM DB_CLIENTE cli
    INNER JOIN DB_CLI_FISICA cfi ON (cli.nr_cliente = cfi.nr_cliente)
    WHERE cli.nr_cliente = 277;
    
    v_dia_semana_nascimento := to_char(v_dt_nascimento, 'DAY');
    
    dbms_output.put_line('O cliente ' || v_nr_cliente || ' - ' || v_nm_cliente || 
                         ' nasceu em ' || v_dt_nascimento || ', em um(a) ' || v_dia_semana_nascimento ||
                         ' e atualmente possui ' || v_qtde_dias_vida || ' dias de vida');
END;