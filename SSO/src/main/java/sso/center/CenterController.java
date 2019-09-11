package sso.center;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CenterController {
    static String uName = "admin";
    static String pw = "123456";

    /**
     * 登录，如果成功就创建token保存在cookie中
     * @param request
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        System.out.println(userName+" "+password);
        if(check(userName,password)){
            System.out.println("!!!");
            Cookie cookie = new Cookie("token","token");
            cookie.setPath("/"); //使该cookie在同一服务器的应用之间共享
            //cookie.setDomain(".xxx");//跨域共享
            response.addCookie(cookie);
            return "success";
        }else{
            return "fail";
        }


    }

    /**
     * 检测用户名密码
     */
    public boolean check(String userName, String password){
        if(userName.equals(uName) && password.equals(pw)){
            return true;
        }else{
            return false;
        }
    }


}
