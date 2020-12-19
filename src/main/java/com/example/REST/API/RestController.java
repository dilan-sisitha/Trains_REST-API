package com.example.REST.API;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(path = "/demo")
public class RestController {
    @Autowired
    private SheduleRepository sheduleRepository;

    @Autowired
    private TrainDetailsRepository trainDetailsRepository;


    // http://localhost:8080/demo/shedules?refno=1105
    @GetMapping(path = "/shedules")
    public @ResponseBody
    List<Shedule> getShedule(@RequestParam String refno) {
        Shedule shedule = new Shedule();
        return sheduleRepository.findByRefno(refno);

    }

    //http://localhost:8080/demo/all
    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Shedule> getShedule() {
        //Shedule shedule =new Shedule();
        return sheduleRepository.findAll();

    }

    // http://localhost:8080/demo/details?refno=1005
    @GetMapping(path = "/details")
    public @ResponseBody
    List<TrainDetails> getDetails(@RequestParam String refno) {
        TrainDetails trainDetails = new TrainDetails();
        return trainDetailsRepository.findByRefno(refno);

    }


}
