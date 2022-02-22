package com.work1.JavaBoot_WorkI.services;

import com.work1.JavaBoot_WorkI.entity.User;
import com.work1.JavaBoot_WorkI.exception.UserNotFoundException;
import com.work1.JavaBoot_WorkI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String checkUsername(String userName) {
        String msg = "";
        Optional<User> result = userRepository.findByUserName(userName);
        if (result.isPresent()) {
            msg = String.format("ยินดีต้อนรันคุณ %s %s", result.get().getName(), result.get().getLastName());
        } else {
            throw new UserNotFoundException(userName);
        }
        return msg;

    }
}
