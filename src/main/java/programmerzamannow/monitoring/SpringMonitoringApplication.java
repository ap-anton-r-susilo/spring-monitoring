package programmerzamannow.monitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringMonitoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMonitoringApplication.class, args);
	}

}
