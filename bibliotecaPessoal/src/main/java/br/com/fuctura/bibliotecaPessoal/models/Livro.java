package br.com.fuctura.bibliotecaPessoal.models;

import br.com.fuctura.bibliotecaPessoal.enuns.Edicao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String autor;
    private String Texto;
    private Edicao edicao;

    @JsonIgnore //#########################
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    private Livro() {
    }

    public Livro(Integer id, String nome, String autor, String texto, Edicao edicao, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.Texto = texto;
        this.edicao = edicao;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return Texto;
    }
    public void setTexto(String texto) {
        Texto = texto;
    }

    public Edicao getEdicao() {
        return edicao;
    }
    public void setEdicao(Edicao edicao) {
        this.edicao = edicao;
    }

    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}

