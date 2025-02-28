package br.com.fiap.view;
import br.com.fiap.dao.ProdutoDao;
import br.com.fiap.exception.EntidadeNaoEncontradaException;
import br.com.fiap.model.Produto;

import java.sql.SQLException;

public class PesquisaProdutoPorIdView {
    public static void main(String[] args) {
        try {
            ProdutoDao dao = new ProdutoDao();
            Produto produto = dao.pesquisar(3);
            System.out.println(produto.getCodigo() + " " + produto.getNome() + ", " + produto.getDescricao());
            System.out.println("R$ " + produto.getValor() + ", " + produto.getEstoque());
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Código não existe na tabela!");
        }

    }
}
