package com.example.demoPipeline.service;

import com.example.demoPipeline.entity.User;
import com.example.demoPipeline.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public User getUserById(Long userId) {
        return userRepo.findById(userId).get();
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }
}
