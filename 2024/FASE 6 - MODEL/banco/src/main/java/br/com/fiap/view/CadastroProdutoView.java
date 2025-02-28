package br.com.fiap.view;

import br.com.fiap.dao.ProdutoDao;
import br.com.fiap.model.Produto;
import br.com.fiap.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CadastroProdutoView {
    public static void main(String[] args) {
        try {
            ProdutoDao dao = new ProdutoDao();
            Produto produto = new Produto("Calça Jeans", "Calça Jeans Azul", 50.0, 10);
            dao.cadastrar(produto);
            dao.fecharConexao();
            System.out.println("Produto cadastrado!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
