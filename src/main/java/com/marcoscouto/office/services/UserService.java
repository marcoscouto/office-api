package com.marcoscouto.office.services;

import com.marcoscouto.office.domain.User;
import com.marcoscouto.office.exceptions.UserNotFoundException;
import com.marcoscouto.office.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User save(User user) {
        user.setId(null);
        return userRepository.save(user);
    }

    public User update(UUID id, User userUpdate) {
        User user = findById(id);
        return userRepository.save(updateDataUser(user, userUpdate));
    }

    public void delete(UUID id) {
        findById(id);
        userRepository.deleteById(id);
    }

    private User updateDataUser(User user, User newUser) {
        if (newUser.getName() != null || newUser.getName() != "") user.setName(newUser.getName());
        if (newUser.getAge() != null) user.setAge(newUser.getAge());
        if (newUser.getOffice() != null || newUser.getOffice() != "") user.setOffice(newUser.getOffice());
        return user;
    }

    public void refreshDatabase() {
        userRepository.deleteAll();

        List<User> users = new ArrayList<>();

        users.add(new User(null, "John", 29, "Java Corp"));
        users.add(new User(null, "Ringo", 24, "Python Corp"));
        users.add(new User(null, "Paul", 42, "Cobol Corp"));
        users.add(new User(null, "George", 42, "PHP Corp"));

        userRepository.saveAll(users);
    }

}
