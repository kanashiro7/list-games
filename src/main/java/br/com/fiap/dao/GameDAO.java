package br.com.fiap.dao;

import br.com.fiap.model.Games;
import jakarta.persistence.EntityManager;

import java.util.List;

public class GameDAO {
        private EntityManager em;

        public GameDAO(EntityManager em){
            this.em = em;
        }

        public void salvar(Games games){
            em.persist(games);
        }

        public void atualizar(Games games){
            em.merge(games);
        }

        public void remover(Games games){
            Games gameExcluir = em.find(Games.class, games.getId());
            em.remove(gameExcluir);
        }

        public Games buscarGamePeloId(Games games){
            return em.find(Games.class, games.getId());
        }


        //Utilizando o método de consulta que existe no JPA = jpql
        public List<Games> listarTodosOsJogos(){
            String jpqlQuery = "SELECT g FROM Games g ORDER BY g.titulo ASC";
            return em.createQuery(jpqlQuery, Games.class).getResultList();
        }
        public List<Games> buscarPeloNome(String titulo){
            String jpqlQuery = "SELECT g FROM Games g WHERE g.titulo = :titulo";
            return em.createQuery(jpqlQuery, Games.class)
                    .setParameter("titulo", titulo)
                    .getResultList();
        }

        public List<Games> buscarJogoPorFaixaDeValores(double valorInicial, double valorFinal){
            String jpqlQuery = "SELECT g FROM Games g WHERE g.Valor BETWEEN :valorInicial and :valorFinal ORDER BY g.titulo ASC";
            return em.createQuery(jpqlQuery, Games.class)
                    .setParameter("valorInicial", valorInicial)
                    .setParameter("valorFinal", valorFinal)
                    .getResultList();

        }
        public List<Games> buscarJogosProdutora(String produtora){
            String jplquery = "SELECT g FROM Games g WHERE g.produtora = :produtora";
            return em.createQuery(jplquery, Games.class)
                    .setParameter("produtora", produtora)
                    .getResultList();
        }



}
