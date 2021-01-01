package com.example.REST.API;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByEmail(String email);

    List<User> findByPassword(String password);
}
