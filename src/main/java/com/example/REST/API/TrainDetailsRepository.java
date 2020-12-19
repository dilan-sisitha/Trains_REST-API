package com.example.REST.API;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrainDetailsRepository extends CrudRepository<TrainDetails, Integer> {
    List<TrainDetails> findByRefno(String refno);

}
