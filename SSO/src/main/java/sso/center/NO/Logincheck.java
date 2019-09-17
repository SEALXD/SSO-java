package sso.center.NO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Logincheck {
    static String COOKIE_KEY = "token";
    static String COOKIE_VAL = "token";

    /**
     * 校验cookie
     *
     * @param request
     * @return
     */
    public static boolean checkCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (COOKIE_KEY.equals(cookie.getName()) && COOKIE_VAL.equals(cookie.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }
}
