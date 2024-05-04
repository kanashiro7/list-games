package br.com.fiap.dao;

import br.com.fiap.model.Games;
import jakarta.persistence.EntityManager;

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

}
