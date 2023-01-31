package com.feliperodrigues.workshopmongo.services;

import com.feliperodrigues.workshopmongo.entities.Post;
import com.feliperodrigues.workshopmongo.entities.User;
import com.feliperodrigues.workshopmongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<Post> findAll(){
        return postRepository.findAll();
    }


    public List<Post> findById(String id){
        return postRepository.findAllById(Collections.singleton(id));
    }
}

