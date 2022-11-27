package com.example.base;

import javax.servlet.http.HttpServletRequest;

import com.example.user.User;

public class ApiBase {

	public static long getUID(HttpServletRequest request) {
		return getUser(request).id;
	}

	public static boolean isLogin(HttpServletRequest request) {
		return getUser(request) != null;
	}

	public static User getUser(HttpServletRequest request) {
		User u = (User) request.getSession().getAttribute("_CC_LOGIN_USER");
//		if (u == null && (!DBConn.isOracle || isAPIDebug)) {
//			u = new User();
//			u.id = 1;
//			u.guid = "xxxxx";
//			u.name = "API测试";
//			u.path = "中心\\admin";
//			u.roles = "MONITOR_AUDIT";
//		}
		if (u != null) {
			u.ip = getIpAddr(request);
		}
		return u;
	}
    
    public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("x-forwarded-for");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
    
    public static void setUser(HttpServletRequest request, User u){
    		request.getSession().setAttribute("_CC_LOGIN_USER", u);
    }
    
    public static void delUser(HttpServletRequest request){
    		request.getSession().removeAttribute("_CC_LOGIN_USER");
    }
}
