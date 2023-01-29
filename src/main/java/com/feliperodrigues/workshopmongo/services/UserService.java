package com.feliperodrigues.workshopmongo.services;

import com.feliperodrigues.workshopmongo.entities.User;
import com.feliperodrigues.workshopmongo.repository.UserRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){

        return userRepository.findAll();
    }


}
