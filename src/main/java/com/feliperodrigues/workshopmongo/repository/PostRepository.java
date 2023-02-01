package com.feliperodrigues.workshopmongo.repository;

import com.feliperodrigues.workshopmongo.entities.Post;
import com.feliperodrigues.workshopmongo.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTittleContainingIgnoreCase(String text);

}
