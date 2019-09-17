package cn.je.test.test.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {
	
	@RequestMapping("/login")
	public String login(HttpSession session,Model model,String userName,String passWord,String redirectURl) {
		if(userName.equals("admin") && passWord.equals("111111")) {
			session.setAttribute("userInfo", "userName=admin");
			String token = "xxxxxxxxx";
			redirectURl = (String) session.getAttribute("redirect");
			return "redirect:"+redirectURl+"?token="+token;
		}else {
			return "login";
		}
		
	}

	/**
	 * 从session中获取userinfo，如果有，返回发出请求的页面和token
	 * @param session
	 * @param redirectURl
	 * @return
	 */
	@RequestMapping("/loginPage")
	public String loginPage(HttpSession session, String redirectURl) {
		String userInfo = (String) session.getAttribute("userInfo");
		if(userInfo != null && !userInfo.equals("")) {
			String token = "xxxxxxxxx2";
			return "redirect:"+redirectURl+"?token="+token;
		}
		session.setAttribute("redirect", redirectURl);
		return "login";
	}

}
