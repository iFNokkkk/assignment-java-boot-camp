package com.work1.JavaBoot_WorkI.repository;

import com.work1.JavaBoot_WorkI.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByUserName() {
        //Arrange
        User user = new User();
        user.setName("Testing");
        user.setUserName("ccx4432");
        userRepository.save(user);

        //Art
        Optional<User> result = userRepository.findByUserName("ccx4432");

        //Assert
        assertTrue(result.isPresent());
    }

    @Test
    @DisplayName("findByNameIsFailure Input ")
    void findByNameIsFailure() {
        //Art
        Optional<User> result = userRepository.findByUserName("Testing");
        //Assert
        assertFalse(result.isPresent());
    }
}