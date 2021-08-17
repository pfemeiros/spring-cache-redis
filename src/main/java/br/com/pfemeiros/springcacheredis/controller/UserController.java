package br.com.pfemeiros.springcacheredis.controller;

import br.com.pfemeiros.springcacheredis.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<String> getUsers(@RequestParam Long id) {
        System.out.println("Buscando usuários...");
        List<String> firstNames = userService.getFirstNames(id);
        List<String> lastNames = userService.getLastNames(id);
        return Stream.of(firstNames, lastNames)
                        .flatMap(Collection::stream)
                                .collect(Collectors.toList());
    }

    @GetMapping("/clean")
    @CacheEvict("getUsers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getUsersCleanCache() {
        System.out.println("Limpando cache...");
    }

    @GetMapping("/clean/getFirstNames")
    @CacheEvict("getFirstNames")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getFirstNamesCleanCache() {
        System.out.println("Limpando cache...");
    }

    @GetMapping("/clean/getLastNames")
    @CacheEvict("getLastNames")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getLastNamesCleanCache() {
        System.out.println("Limpando cache...");
    }

}
