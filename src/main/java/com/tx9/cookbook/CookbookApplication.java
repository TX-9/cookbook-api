package com.tx9.cookbook;
import com.tx9.cookbook.model.Cookbook;
import com.tx9.cookbook.repository.CookbookRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.stream.LongStream;

@SpringBootApplication
public class CookbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(CookbookApplication.class, args);
	}

	@Bean
	CommandLineRunner init(CookbookRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11).mapToObj(i -> new Cookbook(i, "Contact " + i)).map(v -> repository.save(v))
					.forEach(System.out::println);
		};
	}

}
