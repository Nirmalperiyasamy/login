package com.example.anotherlogin.repository;

import com.example.anotherlogin.doa.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, Integer> {
    boolean existsByUsername(String username);

    UserDetails findByUsername(String username);
}
