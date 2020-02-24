package com.marcoscouto.office.services;

import com.marcoscouto.office.domain.User;
import com.marcoscouto.office.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id).get();
    }

    public User save(User user){
        user.setId(null);
        return userRepository.save(user);
    }

    public User update(Long id, User userUpdate){
        User user = findById(id);
        if(user == null) return null;
        return userRepository.save(updateDataUser(user, userUpdate));
    }

    public boolean delete(Long id){
        if(findById(id) == null) return false;
        userRepository.deleteById(id);
        return true;
    }

    private User updateDataUser(User user, User newUser){
        if(newUser.getName() == null || newUser.getName() != "") user.setName(newUser.getName());
        if(newUser.getAge() == null) user.setAge(newUser.getAge());
        if(newUser.getOffice() == null || newUser.getOffice() != "") user.setOffice(newUser.getOffice());
        return user;
    }

}
