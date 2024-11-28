package com.coderscampus;

import com.coderscampus.domain.Channel;
import com.coderscampus.domain.Message;
import com.coderscampus.repository.ChannelRepository;
import com.coderscampus.repository.MessageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JeanAssignment14Application {

	public static void main(String[] args) {
		SpringApplication.run(JeanAssignment14Application.class, args);
	}

}
