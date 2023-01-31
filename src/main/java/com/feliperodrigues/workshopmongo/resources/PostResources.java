package com.feliperodrigues.workshopmongo.resources;

import com.feliperodrigues.workshopmongo.entities.Post;
import com.feliperodrigues.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {

    @Autowired
    PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> findAll(){
        List<Post> post = postService.findAll();
        return ResponseEntity.ok().body(post);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

}
