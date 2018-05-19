package com.pcw.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringHandler {
	@RequestMapping("/emailcode")
	public void emCodeVerify(){
		
	}
	
	public String login(){
		return null;
	}
}
