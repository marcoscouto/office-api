package com.marcoscouto.office.services;

import com.marcoscouto.office.domain.User;
import com.marcoscouto.office.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DBService {

    @Autowired
    private static UserRepository userRepository;

    public static void populateDatabase(){

        userRepository.deleteAll();

        List<User> users = new ArrayList<>();

        users.add(new User(null, "John", 29, "Java Corp"));
        users.add(new User(null, "Ringo", 24, "Python Corp"));
        users.add(new User(null, "Paul", 42, "Cobol Corp"));
        users.add(new User(null, "George", 42, "PHP Corp"));

        userRepository.saveAll(users);

    }

}
