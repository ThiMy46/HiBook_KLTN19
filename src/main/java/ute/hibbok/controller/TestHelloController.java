package ute.hibbok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestHelloController {

	@RequestMapping("/")
	public String testHello() {
		return "hello";
	}
}
