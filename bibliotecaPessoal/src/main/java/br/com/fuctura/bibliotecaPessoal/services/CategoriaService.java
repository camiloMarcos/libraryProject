package br.com.fuctura.bibliotecaPessoal.services;

import br.com.fuctura.bibliotecaPessoal.models.Categoria;
import br.com.fuctura.bibliotecaPessoal.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoriaService {

    @Autowired
    // injetamos a categoria repository, para acessar os metodos do jpa repository.
    private CategoriaRepository categoriaRepositorytory;


    public Categoria findById(Integer id) {
        Optional<Categoria> categoria = categoriaRepositorytory.findById(id);
        return categoria.get();
    }


    public List<Categoria> findAll() {
        List<Categoria> list = categoriaRepositorytory.findAll();
        return list;
    }
/*   public List<Categoria> findAll(){
        return = categoriaRepositorytory.findAll();  */


    public Categoria save(Categoria categoria) {
        return categoriaRepositorytory.save(categoria);
    }

    public Categoria update(Categoria categoria) {

        return categoriaRepositorytory.save(categoria);
    }

    public void delete(Integer id) {
        categoriaRepositorytory.deleteById(id);
    }


   }

