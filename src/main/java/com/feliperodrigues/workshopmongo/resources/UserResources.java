package com.feliperodrigues.workshopmongo.resources;

import com.feliperodrigues.workshopmongo.entities.User;
import com.feliperodrigues.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<List<User>> insert(@RequestBody User user){
        List<User> list = new ArrayList<>();
        list.add(user);
        return ResponseEntity.ok().body(list);
    }
}
