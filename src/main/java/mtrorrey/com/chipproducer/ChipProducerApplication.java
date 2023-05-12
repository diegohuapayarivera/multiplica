package mtrorrey.com.chipproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ChipProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChipProducerApplication.class, args);
	}

}
