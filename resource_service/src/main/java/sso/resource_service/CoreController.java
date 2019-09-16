package sso.resource_service;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class CoreController {
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    String test(){
        System.out.println("run the test");
        return "SUCCESS";
    }


}