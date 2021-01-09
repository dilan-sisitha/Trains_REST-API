package com.example.REST.API;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserLoginRepository extends CrudRepository<UserLogin, Integer> {

   List<UserLogin> findByEmail(String email);
}
