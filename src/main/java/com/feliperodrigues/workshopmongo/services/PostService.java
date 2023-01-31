package com.feliperodrigues.workshopmongo.services;

import com.feliperodrigues.workshopmongo.entities.Post;
import com.feliperodrigues.workshopmongo.repository.PostRepository;
import com.feliperodrigues.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<Post> findAll(){
        return postRepository.findAll();
    }


    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}




