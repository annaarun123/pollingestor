package com.ca.prism.pollingestor;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class Poll {

	@RequestMapping("/")
	String home() {
		return "Poll application!";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Poll.class, args);
	}

}