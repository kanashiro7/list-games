package br.com.fiap.model;

import jakarta.persistence.*;

import java.time.LocalDate;
//Anotação para identificar a entidade no banco de dados
@Entity
@Table(name = "tabela_jogo")
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tabela_jogo_seq")
    @SequenceGenerator(name = "tabela_jogo_seq", sequenceName = "tabela_jogo_seq", allocationSize = 1)
    private long id;
    private String titulo;
    @Column(name = "dt_lancamento")
    private LocalDate dataLancamento;
    private Double Valor;
    private String produtora;
    private boolean finalizado;
    private String categoria;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double valor) {
        Valor = valor;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


}
