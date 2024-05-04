package br.com.fiap;

import br.com.fiap.dao.GameDAO;
import br.com.fiap.model.Games;
import br.com.fiap.utils.Conexao;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        EntityManager em = Conexao.getEntityManager();
        //cadastrar(em);
        //pesquisar(em);
       listarTodosOsGames(em);
        //buscarPeloNome(em);
        //buscarGamesPelosValores(em);
        //buscarJogosProddutora(em);
        em.close();
    }

    //Listando todos os valores que estão inseridos no banco de dados utilizando JPQL
    public static void buscarJogosProddutora(EntityManager em){
        GameDAO gameDAO = new GameDAO(em);
        List<Games> games = gameDAO.buscarJogosProdutora("KONAMI".toUpperCase());

        for (Games game : games){
            System.out.println(game);
            System.out.println("_________________________");
        }
    }

    //Listando todos os valores que estão inseridos no banco de dados utilizando JPQL
    public static void buscarGamesPelosValores(EntityManager em){
        GameDAO gameDAO = new GameDAO(em);
        List<Games> games = gameDAO.buscarJogoPorFaixaDeValores(150.0, 300.0);

        for (Games game : games){
            System.out.println(game);
            System.out.println("_________________________");
        }
    }

    public static void buscarPeloNome(EntityManager em){
        GameDAO gameDAO = new GameDAO(em);
        List<Games> games = gameDAO.buscarPeloNome("GTA V".toUpperCase());

        for (Games game : games){
            System.out.println(game);
            System.out.println("_________________________");
        }
    }

    //Listando todos os valores que estão inseridos no banco de dados utilizando JPQL
    public static void listarTodosOsGames(EntityManager em){
        GameDAO gameDAO = new GameDAO(em);
        List<Games> games = gameDAO.listarTodosOsJogos();

        for (Games game : games){
            System.out.println(game);
            System.out.print("_________________________");
        }
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