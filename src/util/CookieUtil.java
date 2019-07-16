package util;

import javax.servlet.http.Cookie;

public class CookieUtil {
	/**
	 * 这是查找cookie数组中特定字段的cookie
	 * @param cookies
	 * @param name
	 * @return
	 */
	public static Cookie findCookie(Cookie[] cookies , String name) {
		//cookies数组是空的,说明第一次登录,返回空值
		if( cookies !=null) {
			//对cookies数组遍历
			for (Cookie cookie : cookies) {
				if(name.equals(cookie.getName())) {
					return cookie;
				}
			}
		}
		
		return null;
		
	}
}
