package br.com.fuctura.bibliotecaPessoal.repositories;

import br.com.fuctura.bibliotecaPessoal.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    Optional<Categoria> findByNomeIgnoreCaseContaining(String nome);
}
