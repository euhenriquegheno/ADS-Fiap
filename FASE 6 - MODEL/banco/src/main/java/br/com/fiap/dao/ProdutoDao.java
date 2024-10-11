package br.com.fiap.dao;

import br.com.fiap.exception.EntidadeNaoEncontradaException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Produto;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {
    private Connection conexao;

    public ProdutoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void cadastrar(Produto produto) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO tb_produto (cd_produto, nm_produto, ds_produto, vl_produto, nr_estoque) values (seq_produto.nextval, ?, ?, ?, ?)");
        stm.setString(1, produto.getNome());
        stm.setString(2, produto.getDescricao());
        stm.setDouble(3, produto.getValor());
        stm.setInt(4, produto.getEstoque());
        stm.executeUpdate();

    }

    public Produto pesquisar(long codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_produto WHERE cd_produto = ?");
        stm.setLong(1, codigo);
        ResultSet result = stm.executeQuery();

        if (!result.next())
            throw new EntidadeNaoEncontradaException("Produto não encontrado!");

        long id = result.getLong("cd_produto");
        String nome = result.getString("nm_produto");
        String descricao = result.getString("ds_produto");
        double valor = result.getDouble("vl_produto");
        int estoque = result.getInt("nr_estoque");
        return new Produto(id, nome, descricao, valor, estoque);
    }

    public List<Produto> listar() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_produto");
        ResultSet result = stm.executeQuery();

        List<Produto> lista = new ArrayList<>();
        while (result.next()) {
            Long id = result.getLong("cd_produto");
            String nome = result.getString("nm_produto");
            String descricao = result.getString("ds_produto");
            double valor = result.getDouble("vl_produto");
            int estoque = result.getInt("nr_estoque");
            lista.add(new Produto(id, nome, descricao, valor, estoque));
        }
        return lista;
    }

    public void atualizar(Produto produto) {

    }

    public void remover(long codigo) {

    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }
}
