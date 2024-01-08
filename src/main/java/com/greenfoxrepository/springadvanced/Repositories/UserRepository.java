package com.greenfoxrepository.springadvanced.Repositories;

import com.greenfoxrepository.springadvanced.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findAllByEmail(String email);
}
