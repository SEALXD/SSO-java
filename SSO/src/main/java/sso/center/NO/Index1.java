package sso.center.NO;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Index1 {

    @RequestMapping("/sys1")
    public String login1(HttpServletRequest request){
        return Logincheck.checkCookie(request) ? "success" : "indexPage";
    }
}
