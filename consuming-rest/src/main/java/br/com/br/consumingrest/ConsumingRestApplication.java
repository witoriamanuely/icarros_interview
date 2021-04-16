package br.com.br.consumingrest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ConsumingRestApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ConsumingRestApplication.class);
		app.run(args);
	}

}
