package com.feliperodrigues.workshopmongo.config;

import com.feliperodrigues.workshopmongo.entities.User;
import com.feliperodrigues.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
@Configuration
public class Program implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        User laura = new User(null, "Laura Vitória  Campelo Rodrigues", "laura@gmail.com");
        User stella = new User(null, "Stella Sophia Campelo Rodrigues", "stella@gmail.com");
        User felipe = new User(null, "Luis Felipe Rodrigues", "luisfelipe@gmail.com");




        userRepository.saveAll(Arrays.asList(maria, alex, bob, laura, stella, felipe));



    }
}
