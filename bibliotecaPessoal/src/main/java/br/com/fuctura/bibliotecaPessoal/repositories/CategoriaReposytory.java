package br.com.fuctura.bibliotecaPessoal.repositories;

import br.com.fuctura.bibliotecaPessoal.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaReposytory extends JpaRepository<Categoria, Integer> {
}
