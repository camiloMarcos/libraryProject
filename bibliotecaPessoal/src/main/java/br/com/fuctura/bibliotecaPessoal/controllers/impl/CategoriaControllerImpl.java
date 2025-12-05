package br.com.fuctura.bibliotecaPessoal.controllers.impl;

import br.com.fuctura.bibliotecaPessoal.controllers.CategoriaController;
import br.com.fuctura.bibliotecaPessoal.dtos.CategoriaDto;
import br.com.fuctura.bibliotecaPessoal.models.Categoria;
import br.com.fuctura.bibliotecaPessoal.services.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController                                                                         //controlador REST que implementa a interface CategoriaController
@RequestMapping("/categoria")                                                           //mapeia as requisições HTTP para o endpoint /categorias
public class CategoriaControllerImpl implements CategoriaController {


    @Autowired
    private CategoriaService categoriaService;                                          //injeção de dependência do serviço CategoriaService
    @Autowired
    private ModelMapper modelMapper;                                                    //injeção de dependência do ModelMapper para conversão entre entidades e DTOs


    @Override
    @GetMapping("/{id}")                                                                //mapeia as requisições HTTP GET para o endpoint /categorias/{id}
    public ResponseEntity<CategoriaDto> findById(@PathVariable Integer id) {            //variavel de path para capturar o ID da categoria na URL
        Categoria categoria = categoriaService.findById(id);                            //chama o método findById do serviço para buscar a categoria pelo ID
        return ResponseEntity.ok().body(modelMapper.map(categoria, CategoriaDto.class));
   }

    @Override
    @GetMapping
    public ResponseEntity<List<CategoriaDto>> findAll() {
        List<Categoria> list = categoriaService.findAll();
        return ResponseEntity.ok().body(list.stream().map(obj ->
               modelMapper.map(obj, CategoriaDto.class)).collect(Collectors.toList()));
    }


    @Override
    @PostMapping                                                                                 // @PostMapping para mapear requisições HTTP POST para o endpoint /categorias
    public ResponseEntity<CategoriaDto> save(@RequestBody CategoriaDto categoriaDto) {          //@RequestBody para indicar que o objeto categoria será recebido no corpo da requisição HTTP
        Categoria categoria = modelMapper.map(categoriaDto, Categoria.class);
        Categoria cat = categoriaService.save(categoria);
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDto.class));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDto> update(@PathVariable Integer id,@RequestBody CategoriaDto categoriaDto) {
        categoriaDto.setId(id);
        Categoria categoria = modelMapper.map(categoriaDto, Categoria.class);
        Categoria cat = categoriaService.update(categoria);
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDto.class));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  delete(@PathVariable Integer id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}



// @GetMapping ("/{id}")
// findById =>  metodo para buscar uma categoria pelo seu ID

// @GetMapping
// findAll = metodo para buscar todas as categorias

//@PostMapping
// save = metodo para salvar uma nova categoria

//@PutMapping ("/{id}")
// update = metodo para atualizar uma categoria existente

//@DeleteMapping ("/{id}")
// delete = metodo para deletar uma categoria pelo seu ID

// localhost:8080/categoria