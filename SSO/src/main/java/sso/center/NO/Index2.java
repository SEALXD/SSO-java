package sso.center.NO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Index2 {
//    @RequestMapping("/index2")
//    public String index(){
//        return "indexPage2";
//    }

    @RequestMapping("/sys2")
    public String login2(HttpServletRequest request){
        return Logincheck.checkCookie(request) ? "success" : "indexPage";
    }
}
