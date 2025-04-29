package br.com.fiap;

import br.com.fiap.dao.CategoriaDao;
import br.com.fiap.dao.GameDao;
import br.com.fiap.model.Categoria;
import br.com.fiap.model.Game;
import br.com.fiap.utils.Conexao;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Main {

    public static void buscarCategoriaPeloId(EntityManager em){
        CategoriaDao categoriaDao = new CategoriaDao(em);
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        Categoria categoriaEncontrada = categoriaDao.buscarCategoriaPeloId(categoria);
        System.out.println(categoriaEncontrada.toString());
    }

    public static void buscarGamesFaixaDeLancamento(EntityManager em) {
        GameDao gameDao = new GameDao(em);
        List<Game> games = gameDao.buscarGamesFaixaDeLancamento(LocalDate.now().minusMonths(2), LocalDate.now().plusYears(100));

        for (Game game : games) {
            System.out.println(game);
            System.out.println("----------------------");
        }
    }

    public static void buscarGamesPeloStatus(EntityManager em) {
        GameDao gameDao = new GameDao(em);
        List<Game> games = gameDao.buscarGamesPeloStatus(true);

        for (Game game : games) {
            System.out.println(game);
            System.out.println("----------------------");
        }
    }

    public static void buscarGamePeloProdutora(EntityManager em) {
        GameDao gameDao = new GameDao(em);
        List<Game> games = gameDao.buscarGamesPelaProdutora("nintendo".toUpperCase());

        for (Game game : games) {
            System.out.println(game);
            System.out.println("----------------------");
        }
    }

    public static void buscarGamesPorFaixaDeValores(EntityManager em) {
        GameDao gameDao = new GameDao(em);
        List<Game> games = gameDao.buscarGamesPorFaixaDeValores(150.0, 300.0);

        for (Game game : games) {
            System.out.println(game);
            System.out.println("----------------------");
        }
    }

    public static void buscarGamePeloNome(EntityManager em) {
        GameDao gameDao = new GameDao(em);
        List<Game> games = gameDao.buscarGamePeloNome("mega man 2".toUpperCase());

        for (Game game : games) {
            System.out.println(game);
            System.out.println("----------------------");
        }
    }

    public static void listarTodosGames(EntityManager em) {
        GameDao gameDao = new GameDao(em);
        List<Game> games = gameDao.listarTodosGames();

        for (Game game : games) {
            System.out.println(game);
            System.out.println("----------------------");
        }
    }

    public static void pesquisar(EntityManager em) {
        GameDao gameDao = new GameDao(em);
        Game game = new Game();
        game.setId(2L);
        Game gameEncontrado = gameDao.buscarPorId(game);

        if (gameEncontrado != null) {
            System.out.println(gameEncontrado.toString());
        } else {
            System.out.println("Game não encontrado!");
        }
    }

    public static void cadastrar(EntityManager em) {

        // Criamos uma categoria
        Categoria luta = new Categoria();
        //luta.setNomeCategoria("LUTA");
        luta.setId(1L);

        // Criamos uma instância de CategoriaDao
        //CategoriaDao categoriaDao = new CategoriaDao(em);

        // Iniciamos uma transação de dados no banco
        em.getTransaction().begin();

        // Chamamos o método salvar de CategoriaDao
        // para persistir uma categoria no banco
        //categoriaDao.salvar(luta);

        // Criamos um jogo da categoria luta
        Game game1 = new Game();
        game1.setTitulo("Street Fighter II");
        game1.setCategoria(luta);
        game1.setDataLancamento(LocalDate.of(1992, 2, 1));
        game1.setFinalizado(true);
        game1.setProdutora("Capcom");
        game1.setValor(399.99);

        // Criação de uma instância de GameDao
        GameDao gameDao = new GameDao(em);

        // Chamamos o método salvar de GameDao
        // para persistir um jogo no banco
        gameDao.salvar(game1);

        // Efetuamos o commit para sincronizar
        // no banco de dados todas as alterações
        em.getTransaction().commit();

        // Fechamos a EntityManager
        em.close();
    }

    public static void main(String[] args) {

        EntityManager em = Conexao.getEntityManager();

//        cadastrar(em);
//        pesquisar(em);
//        listarTodosGames(em);
//        buscarGamePeloNome(em);
        buscarCategoriaPeloId(em);

        em.close();

    }
}