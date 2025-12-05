package br.com.fuctura.bibliotecaPessoal.controllers;

import br.com.fuctura.bibliotecaPessoal.dtos.CategoriaDto;
import br.com.fuctura.bibliotecaPessoal.models.Categoria;
import br.com.fuctura.bibliotecaPessoal.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public interface CategoriaController {

    //  Os métodos que serão implementados na classe CategoriaControllerImpl, CONTRATO

   ResponseEntity<CategoriaDto> findById(Integer id);

   ResponseEntity<List<CategoriaDto>> findAll();

   ResponseEntity<CategoriaDto> save(CategoriaDto categoriaDto);

   ResponseEntity<CategoriaDto> update (Integer id, CategoriaDto categoriaDto);

   ResponseEntity<Void> delete(Integer id);
}
