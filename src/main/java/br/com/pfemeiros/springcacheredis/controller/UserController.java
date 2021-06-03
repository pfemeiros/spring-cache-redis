package br.com.pfemeiros.springcacheredis.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    @Cacheable("getUsers")
    public List<String> getUsers() {
        System.out.println("Buscando usuários...");
        return List.of("Pedro", "João", "Maria");
    }

    @GetMapping("/clean")
    @CacheEvict("getUsers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getUsersCleanCache() {
        System.out.println("Limpando cache...");
    }

}
