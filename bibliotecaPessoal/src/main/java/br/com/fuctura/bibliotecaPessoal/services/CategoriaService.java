package br.com.fuctura.bibliotecaPessoal.services;

import br.com.fuctura.bibliotecaPessoal.exceptions.ObjectNotFoundException;
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
        return categoria.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada com esse ID: " + id));
    }


    public List<Categoria> findAll() {
        List<Categoria> list = categoriaRepositorytory.findAll();
        if (list.isEmpty()) {
            throw new ObjectNotFoundException("Nenhuma categoria encontrada");
        }
        return list;
    }
/*   public List<Categoria> findAll(){
        return = categoriaRepositorytory.findAll();  */


    public Categoria save(Categoria categoria) {
        buscarPorNome(categoria);
        return categoriaRepositorytory.save(categoria);
    }

    public Categoria update(Categoria categoria) {
        findById(categoria.getId());
        buscarPorNome(categoria);
        return categoriaRepositorytory.save(categoria);
    }

    public void delete(Integer id) {
        categoriaRepositorytory.deleteById(id);
    }

    private void buscarPorNome(Categoria categoria) {
        Optional<Categoria> cat = categoriaRepositorytory.findByNomeIgnoreCaseContaining(categoria.getNome());
        if (cat.isPresent()) {
            if (cat.get().getId() != categoria.getId()) {
                throw new IllegalArgumentException("Já existe uma categoria com esse nome: " + categoria.getNome());
            }
        }


    }

}