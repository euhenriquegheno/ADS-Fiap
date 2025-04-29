package br.com.fiap.dao;

import br.com.fiap.model.Game;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class GameDao {

    private EntityManager em;

    public GameDao(EntityManager em) {
        this.em = em;
    }

    public void salvar(Game game) {
        em.persist(game);
    }

    public void excluir(Game game) {
        Game gameExcluir = em.find(Game.class, game.getId());
        em.remove(gameExcluir);
    }

    public void atualizar(Game game) {
        em.merge(game);
    }

    public Game buscarPorId(Game game) {
        return em.find(Game.class, game.getId());
    }

    public List<Game> listarTodosGames() {
        String jpqlQuery = "SELECT g FROM Game g ORDER BY g.titulo ASC";
        return em.createQuery(jpqlQuery, Game.class).getResultList();
    }

    public List<Game> buscarGamePeloNome(String titulo) {
        String jpqlQuery = "SELECT g FROM Game g WHERE g.titulo = :titulo";
        return em.createQuery(jpqlQuery, Game.class)
                .setParameter("titulo", titulo)
                .getResultList();
    }

    public List<Game> buscarGamesPorFaixaDeValores(Double valorInicial, Double ValorFinal) {
        String jpqlQuery = "SELECT g FROM Game G WHERE g.valor BETWEEN :valorInicial AND :valorFinal";
        return em.createQuery(jpqlQuery, Game.class)
                .setParameter("valorInicial", valorInicial)
                .setParameter("valorFinal", ValorFinal)
                .getResultList();
    }

    public List<Game> buscarGamesPelaProdutora(String produtora) {
        String jpqlQuery = "SELECT g FROM Game g WHERE g.produtora = :produtora";
        return em.createQuery(jpqlQuery, Game.class)
                .setParameter("produtora", produtora)
                .getResultList();
    }

    public List<Game> buscarGamesPeloStatus(Boolean finalizado) {
        String jpqlQuery = "";

        if (finalizado) {
            jpqlQuery = "SELECT g FROM Game g WHERE g.finalizado = 1";
        } else {
            jpqlQuery = "SELECT g FROM Game g WHERE g.finalizado = 0";
        }

        return em.createQuery(jpqlQuery, Game.class)
                .setParameter("finalizado", finalizado)
                .getResultList();
    }

    public List<Game> buscarGamesFaixaDeLancamento(LocalDate dataInicial, LocalDate dataFinal) {
        String jpqlQuery = "SELECT g FROM Game G WHERE g.data_lancamento BETWEEN :dataInicial AND :dataFinal";
        return em.createQuery(jpqlQuery, Game.class)
                .setParameter("dataInicial", dataInicial)
                .setParameter("dataFinal", dataFinal)
                .getResultList();
    }

}
