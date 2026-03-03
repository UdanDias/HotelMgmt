package lk.HotelMgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableJpaRepositories
@EnableWebMvc
public class HotelMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelMgmtApplication.class, args);
		System.out.println("Hotel Booking System Application Started");
        System.out.println("This is my first first comment");
	}
}
