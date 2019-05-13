package com.rest.resource;

import com.rest.model.Post;
import com.rest.repository.PostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostResource {

    @Autowired
    private PostRepository repository;

    @PostMapping
    public ResponseEntity<Post> cadastrar(@Valid @RequestBody Post post){
        if (post.equals(null))
            return ResponseEntity.noContent().build();

        repository.save(post);

        return ResponseEntity.ok(post);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> atualizar(@PathVariable Long id, @RequestBody Post post){
        if (id < 1)
            ResponseEntity.notFound().build();
        if (post.equals(null))
            ResponseEntity.notFound().build();

        Post existente = repository.findPostBy(id);

        if (existente.equals(null))
            ResponseEntity.noContent().build();

        //copia todos os atributos e ignora o id
        BeanUtils.copyProperties(post, existente, "id");

        //salva o objeto mandado, substituindo o objeto existente
        repository.save(existente);

        return ResponseEntity.ok(existente);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Post> buscar(@PathVariable Long id){
        if (id < 1)
            return ResponseEntity.notFound().build();

        Post p = repository.findPostBy(id);

        if (p == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(p);
    }

    @GetMapping
    public List<Post> listar(){
        List<Post> lista = repository.findAll();

        return  lista;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        if (id < 1)
            return ResponseEntity.notFound().build();

        Post p = repository.findPostBy(id);

        if (p == null)
            return ResponseEntity.notFound().build();

        repository.delete(p);

        return ResponseEntity.noContent().build();
    }

}
