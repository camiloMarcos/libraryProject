package br.com.fuctura.bibliotecaPessoal.services;

import br.com.fuctura.bibliotecaPessoal.enuns.Edicao;
import br.com.fuctura.bibliotecaPessoal.models.Categoria;
import br.com.fuctura.bibliotecaPessoal.models.Livro;
import br.com.fuctura.bibliotecaPessoal.repositories.CategoriaRepository;
import br.com.fuctura.bibliotecaPessoal.repositories.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    // @RequiredArgsConstructor ->1 outras formas de instanciar uma classe, injeção.
    private CategoriaRepository categoriaReposytory;
    // private final CategoriaReposytory categoriaReposytory; ->1

    @Autowired
    private LivroRepository livroRepository;

    public void inicializaDB() {
        Categoria cat1 = new Categoria(null, "Infórmatica", "Livros de infórmatica");
        Categoria cat2 = new Categoria(null, "Ficção científica", "Livros de ficção científica");
        Categoria cat3 = new Categoria(null, "Biografia", "Livros de biografias");

        Livro l1 = new Livro(null, "Clean code", "Robertin Martin", "Lorem ipsum", Edicao.PRIMEIRA, cat1);
        Livro l2 = new Livro(null, "Engenharia do software", "Louis V. Gerstner", "Lorem ipsum", Edicao.TERCEIRA, cat1);
        Livro l3 = new Livro(null, "The war of the worlds", "H. G. Wells", "Lorem ipsum", Edicao.PRIMEIRA, cat2);
        Livro l4 = new Livro(null, "The time machine", "H. G. Wells", "Lorem ipsum", Edicao.SEGUNDA, cat2);
        Livro l5 = new Livro(null, "I, robot", "Isaac Asimov", "Lorem ipsum", Edicao.TERCEIRA, cat2);

        cat1.getLivros().addAll(Arrays.asList(l1, l2));
        cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));

        categoriaReposytory.saveAll(Arrays.asList(cat1, cat2, cat3));
        livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));

    }



}
