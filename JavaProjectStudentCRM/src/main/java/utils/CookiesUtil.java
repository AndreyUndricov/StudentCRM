package utils;

import javax.servlet.http.Cookie;

public class CookiesUtil {

    public static boolean isContainCookie(Cookie[] cookies, String cookieName) {
        if (cookies == null) {
            return false;
        }
        for (Cookie c : cookies) {
            if (c.getName().equals(cookieName))
                return true;
        }
        return false;
    }

    public static Cookie getCookieByName(String cookieName, Cookie[] cookies) {
        if (cookies == null){
            return null;
        }
        for (Cookie c : cookies) {
            if (c.getName().equals(cookieName))
                return c;
        }
        return null;
    }
}

