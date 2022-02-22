package com.work1.JavaBoot_WorkI.repository;

import com.work1.JavaBoot_WorkI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByName(String name);

    Optional<User> findByUserName(String username);
}
