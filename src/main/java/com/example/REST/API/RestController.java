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

    @Autowired
    private UserRepository userRepository;

    //http://localhost:8080/demo/checkuser?email=admin&password=123&deviceid=PPR1.180610.011
    private static int status = 0;


    // http://localhost:8080/demo/shedules?refno=1105
    @GetMapping(path = "/shedules")
    public @ResponseBody
    List<Shedule> getShedule(@RequestParam String refno) {
        Shedule shedule = new Shedule();
        return sheduleRepository.findByRefno(refno);

    }



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

        return sheduleRepository.findAll();

    }

    //http://localhost:8080/demo/allusers
    @GetMapping(path = "/allusers")
    public @ResponseBody
    Iterable<User> getUsers() {

        return userRepository.findAll();

    }

    //http://localhost:8080/demo/alltraindetails
    @GetMapping(path = "/alltraindetails")
    public @ResponseBody
    Iterable<TrainDetails> getTrains() {

        return trainDetailsRepository.findAll();

    }

    //http://localhost:8080/demo/checklogin?email=aaa&deviceid=saa
    int loginstatus;
    @Autowired
    private UserLoginRepository userLoginRepository;

    @GetMapping(path = "/checkuser")
    public @ResponseBody
    int checkuser(@RequestParam String email, @RequestParam String password, @RequestParam String deviceid) {


        List<User> userslist = userRepository.findByEmail(email);
        if (!userslist.isEmpty()) {
            for (User u : userslist) {
                String pass = u.getPassword();
                if (pass.equals(password)) {
                    //if email and passowrd is correct
                    List<UserLogin> userLoginList = userLoginRepository.findByEmail(email);
                    if (!userLoginList.isEmpty()) {
                        for (UserLogin login : userLoginList) {
                            String id = login.getDeviceId();
                            if (id.equals(deviceid)) {
                                //  loginstatus ="device matches with email";
                                status = 100;

                            } else {
                                //loginstatus = "new device with same email";
                                status = 101;
                            }

                        }
                    } else {
                        //loginstatus="no users with the email new user";
                        status = 100;
                    }


                } else {
                    //email and password doesn't match
                    status = 104;
                }

            }
        } else {

            //no such email
            status = 105;
        }

        return status;
    }

    @GetMapping(path = "/checklogin")
    public @ResponseBody
    int checklogin(@RequestParam String email, @RequestParam String deviceid) {


        List<UserLogin> userLoginList = userLoginRepository.findByEmail(email);
        if (!userLoginList.isEmpty()) {
            for (UserLogin u : userLoginList) {
                String id = u.getDeviceId();
                if (id.equals(deviceid)) {
                    //  loginstatus ="device matches with email";
                    loginstatus = 1;

                } else {
                    //loginstatus = "new device with same email";
                    loginstatus = 0;
                }

            }
        } else {
            //loginstatus="no users with the email";
            loginstatus = 1;
        }

        return loginstatus;
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
    String addShedule(@RequestParam String refno, @RequestParam String station, @RequestParam String sub_station, @RequestParam String arrival,
                      @RequestParam String departure, @RequestParam String crossing, @RequestParam String park,
                      @RequestParam String pt, @RequestParam String other) {

        Shedule shedule = new Shedule();
        shedule.setRefno(refno);
        shedule.setStation(station);
        shedule.setArrival(arrival);
        shedule.setDeparture(departure);
        shedule.setCrossing(crossing);
        shedule.setPark(park);
        shedule.setPt(pt);
        shedule.setOther(other);
        shedule.setSub_station(sub_station);

        sheduleRepository.save(shedule);

        return "Shedule added";
    }

    // http://localhost:8080/demo/adddetail?refno=0000&details=detail1&formno=form1&info=pt01&other=informationishere
    @GetMapping(path = "/adddetail")
    public @ResponseBody
    String addDetail(@RequestParam String refno, @RequestParam String details, @RequestParam String formno, @RequestParam String info, @RequestParam String other) {

        TrainDetails trainDetails = new TrainDetails();
        trainDetails.setRefno(refno);
        trainDetails.setDetails(details);
        trainDetails.setForm_no(formno);
        trainDetails.setInfo(info);
        trainDetails.setOther(other);


        trainDetailsRepository.save(trainDetails);
        return "detial added";
    }

    // http://localhost:5000/demo/logindetail?email=myemail&deviceid=d0001&android=a0001&brand=brand01&model=model01&date=2021
    @GetMapping(path = "/logindetail")
    public @ResponseBody
    String addLoginDetails(@RequestParam String email, @RequestParam String deviceid, @RequestParam String android,
                           @RequestParam String brand, @RequestParam String model, @RequestParam String date) {

        UserLogin userLogin = new UserLogin();
        userLogin.setEmail(email);
        userLogin.setDeviceId(deviceid);
        userLogin.setAndroidId(android);
        userLogin.setBrand(brand);
        userLogin.setModel(model);
        userLogin.setDateTime(date);


        userLoginRepository.save(userLogin);
        return "login detial added";
    }

}
