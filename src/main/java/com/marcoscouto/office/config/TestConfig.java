package com.marcoscouto.office.config;

import com.marcoscouto.office.domain.User;
import com.marcoscouto.office.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        List<User> users = new ArrayList<>();

        users.add(new User(null, "John", 29, "Java Corp"));
        users.add(new User(null, "Marie", 24, "PHP Corp"));
        users.add(new User(null, "Paul", 42, "Cobol Corp"));

        userRepository.saveAll(users);

    }
}
