package com.feliperodrigues.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.feliperodrigues.workshopmongo.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	

	
    List<Post> findByTittleContainingIgnoreCase(String text);

}
