package com.example.REST.API;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SheduleRepository extends CrudRepository<Shedule, Integer> {
    List<Shedule> findByRefno(String refno);

}
