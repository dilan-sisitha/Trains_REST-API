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

    // http://localhost:8080/demo/checkuser?email=admin&password=123
    private static int Status = 0;


    // http://localhost:8080/demo/shedules?refno=1105
    @GetMapping(path = "/shedules")
    public @ResponseBody
    List<Shedule> getShedule(@RequestParam String refno) {
        Shedule shedule = new Shedule();
        return sheduleRepository.findByRefno(refno);

    }

    @Autowired
    private UserRepository userRepository;

    // http://localhost:8080/demo/details?refno=1005
    @GetMapping(path = "/details")
    public @ResponseBody
    List<TrainDetails> getDetails(@RequestParam String refno) {
        TrainDetails trainDetails = new TrainDetails();
        return trainDetailsRepository.findByRefno(refno);

    }


    // http://localhost:8080/demo/checkrefno?refno=1005


    @GetMapping(path = "/checkrefno")
    public @ResponseBody
    int checkref(@RequestParam String refno) {
        List<TrainDetails> details = trainDetailsRepository.findByRefno(refno);
        if (details.isEmpty())
            return 0;
        else
            return 1;
    }

    //http://localhost:8080/demo/allshedules
    @GetMapping(path = "/allshedules")
    public @ResponseBody
    Iterable<Shedule> getShedule() {
        //Shedule shedule =new Shedule();
        return sheduleRepository.findAll();

    }

    @GetMapping(path = "/checkuser")
    public @ResponseBody
    int adduser(@RequestParam String email, @RequestParam String password) {


        List<User> userslist = userRepository.findByEmail(email);
        if (!userslist.isEmpty()) {
            for (User u : userslist) {
                String pass = u.getPassword();
                if (pass.equals(password)) {
                    Status = 1;

                } else {
                    Status = 0;
                }

            }
        } else {
            Status = 0;
        }

        return Status;
    }


    // http://localhost:8080/demo/adduser?username=dilan&email=dilan123&password=123
    @GetMapping(path = "/adduser")
    public @ResponseBody
    String addUser(@RequestParam String username, @RequestParam String email, @RequestParam String password) {

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        userRepository.save(user);
        return "User Saved";
    }

    // http://localhost:8080/demo/addshedule?refno=0000&station=DIL&arrival=11.11&departure=11.11&crossing11.11&park=11.11
    @GetMapping(path = "/addshedule")
    public @ResponseBody
    String addShedule(@RequestParam String refno, @RequestParam String station, @RequestParam String arrival,
                      @RequestParam String departure, @RequestParam String crossing, @RequestParam String park) {

        Shedule shedule = new Shedule();
        shedule.setRefno(refno);
        shedule.setStation(station);
        shedule.setArrival(arrival);
        shedule.setDeparture(departure);
        shedule.setCrossing(crossing);
        shedule.setPark(park);

        sheduleRepository.save(shedule);

        return "Shedule added";
    }

}
