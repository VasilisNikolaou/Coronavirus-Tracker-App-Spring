package coronavirus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringCoronaTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoronaTrackerApplication.class, args);
	}

}
