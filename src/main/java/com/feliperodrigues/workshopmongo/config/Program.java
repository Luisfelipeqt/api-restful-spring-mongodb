package com.feliperodrigues.workshopmongo.config;

import com.feliperodrigues.workshopmongo.dto.AuthorDTO;
import com.feliperodrigues.workshopmongo.dto.CommentDTO;
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
        postRepository.deleteAll();


        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        User laura = new User(null, "Laura Vitória  Campelo Rodrigues", "laura@gmail.com");
        User stella = new User(null, "Stella Sophia Campelo Rodrigues", "stella@gmail.com");
        User felipe = new User(null, "Luis Felipe Rodrigues", "luisfelipe@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob, laura, stella, felipe));


        Post post1 = new Post(null, sdf.parse("29/01/2023"),"Partiu viagem", "Vou viajar para São Paulo, abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("29/01/2023"),"Partiu viagem", "Vou viajar para São Paulo, abraços!", new AuthorDTO(alex));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("31/01/2023"), new AuthorDTO(stella));
        CommentDTO c2 = new CommentDTO("Aproveite!!", sdf.parse("31/01/2023"), new AuthorDTO(felipe));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!!", sdf.parse("31/01/2023"), new AuthorDTO(alex));

        post1.getList().addAll(Arrays.asList(c1, c2));
        post1.getList().addAll(Arrays.asList(c3));


        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getList().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);




    }
}
