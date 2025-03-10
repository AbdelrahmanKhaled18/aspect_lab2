package com.example.lab2.service;

import com.example.lab2.entity.AppUser;
import com.example.lab2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public AppUser createUser(AppUser appUser) {
        return userRepository.save(appUser);
    }

    public AppUser getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public AppUser updateUser(Long id, AppUser appUserDetails) {
        AppUser appUser = userRepository.findById(id).orElse(null);
        if (appUser != null) {
            appUser.setName(appUserDetails.getName());
            appUser.setEmail(appUserDetails.getEmail());
            return userRepository.save(appUser);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
