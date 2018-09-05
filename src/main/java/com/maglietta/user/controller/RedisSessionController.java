package com.maglietta.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisSessionController {
	@GetMapping("/session")
	String uid(HttpSession session) {
		return session.getId();
	}
}
