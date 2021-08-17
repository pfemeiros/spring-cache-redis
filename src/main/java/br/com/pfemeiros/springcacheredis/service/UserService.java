package br.com.pfemeiros.springcacheredis.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Cacheable("getFirstNames")
    public List<String> getFirstNames(Long id) {
        System.out.println("First name...");
        return List.of("Pedro", "Jose");
    }

    @Cacheable("getLastNames")
    public List<String> getLastNames(Long id) {
        System.out.println("Last name...");
        return List.of("Medeiros", "Silva");
    }

}
