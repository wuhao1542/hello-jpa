package com.example.jpa.api;

import com.example.jpa.entities.User;
import com.example.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class DemoController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(path = "/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping(path = "/get-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    @PostMapping(path = "/save-all", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveAll(@RequestBody List<User> users) {
        userRepository.deleteAllInBatch();
        List<User> list = IntStream.range(0, 1000)
                .mapToObj(i -> new User("foo" + i, "desc"))
                .collect(Collectors.toList());
        userRepository.saveAll(list);
    }

    @Transactional
    @PostMapping(path = "/delete/{desc}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteByDescription(@PathVariable("desc") String desc) {
        userRepository.deleteNativeByDescription(desc);
    }

}
