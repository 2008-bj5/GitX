package com.example.user;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.base.ApiBase;

@Controller
@RequestMapping("/api/user")
public class Api extends ApiBase{
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/index")
    public String index(HttpServletRequest req){
		log.info("Session = {}", req.getSession().getId());
		
        return  "/web/index.html";
    }
	
	@PostMapping("/get")
	@ResponseBody
    public User get(HttpServletRequest req, @RequestParam String vo){
		
		log.info("Session = {}", req.getSession().getId());
		
		log.info("vo = {}", vo);
		
		User u = new User();
		u.id = 1;
		
        return  u;
    }
	
}
