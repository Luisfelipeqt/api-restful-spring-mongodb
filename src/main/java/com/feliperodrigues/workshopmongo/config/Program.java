package com.feliperodrigues.workshopmongo.config;

import com.feliperodrigues.workshopmongo.entities.Post;
import com.feliperodrigues.workshopmongo.entities.User;
import com.feliperodrigues.workshopmongo.repository.PostRepository;
import com.feliperodrigues.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Program implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        User laura = new User(null, "Laura Vitória  Campelo Rodrigues", "laura@gmail.com");
        User stella = new User(null, "Stella Sophia Campelo Rodrigues", "stella@gmail.com");
        User felipe = new User(null, "Luis Felipe Rodrigues", "luisfelipe@gmail.com");

        Post post1 = new Post(null, sdf.parse("29/01/2023"),"Partiu viagem", "Vou viajar para São Paulo, abraços!", stella);
        Post post2 = new Post(null, sdf.parse("29/01/2023"),"Partiu viagem", "Vou viajar para São Paulo, abraços!", felipe);



        userRepository.saveAll(Arrays.asList(maria, alex, bob, laura, stella, felipe));

        postRepository.saveAll(Arrays.asList(post1, post2));




    }
}
