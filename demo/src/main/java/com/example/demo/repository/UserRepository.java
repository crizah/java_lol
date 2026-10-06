package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;
import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, UUID>{
    // optional keyword means *User may or may not exist
    Optional<User> findByEmail(String email);
}
