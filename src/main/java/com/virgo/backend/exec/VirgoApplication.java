package com.virgo.backend.exec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//(scanBasePackages = {"com.virgo.backend.service","com.virgo.backend.controller"})
@EnableJpaRepositories(basePackages = {"com.virgo.backend.repository"} )
@EntityScan( basePackages = {"com.virgo.backend.model"} )
public class VirgoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirgoApplication.class, args);
	}

}
