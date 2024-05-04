package br.com.fiap;

import br.com.fiap.dao.GameDAO;
import br.com.fiap.model.Games;
import br.com.fiap.utils.Conexao;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EntityManager em = Conexao.getEntityManager();
        pesquisar(em);
        em.close();
    }

    public static void pesquisar(EntityManager em){
        GameDAO gameDAO = new GameDAO(em);
        Games games = new Games();
        games.setId(27L);
        Games gameEncontrado = gameDAO.buscarGamePeloId(games);
        if (gameEncontrado != null){
            System.out.println(gameEncontrado.toString());
        } else {
            System.out.println("Game não encontrado");
        }
    }
        public static void cadastrar(EntityManager em){
            Games game1 = new Games();
            game1.setTitulo("Fortnite");
            game1.setCategoria("PC/Videogame");
            game1.setDataLancamento(LocalDate.of(2017, 11,12));
            game1.setFinalizado(true);
            game1.setProdutora("Epic Games");
            game1.setValor(0.0);

            GameDAO gameDAO = new GameDAO(em);
            //Iniciar uma transação para o banco de dados
            em.getTransaction().begin();
            //Falando pro EntityManager persistir no game1 criado.
            gameDAO.salvar(game1);
            //Commitar a transação feita para o banco de dados.
            em.getTransaction().commit();
            //Fechar os recursos
            em.close();
            {
    }
        }
    }