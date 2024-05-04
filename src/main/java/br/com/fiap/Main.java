package br.com.fiap;

import br.com.fiap.dao.GameDAO;
import br.com.fiap.model.Games;
import br.com.fiap.utils.Conexao;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            Games game1 = new Games();
            game1.setTitulo("God of War");
            game1.setCategoria("Videogame");
            game1.setDataLancamento(LocalDate.of(2008, 12,1));
            game1.setFinalizado(true);
            game1.setProdutora("Sony");
            game1.setValor(173.3);

        EntityManager em = Conexao.getEntityManager();
        GameDAO gameDAO = new GameDAO(em);

        //Iniciar uma transação para o banco de dados
        em.getTransaction().begin();
        //Falando pro EntityManager persistir no game1 criado.
        em.persist(game1);
        //Commitar a transação feita para o banco de dados.
        em.getTransaction().commit();
        //Fechar a transação
        em.close();

    }
    }