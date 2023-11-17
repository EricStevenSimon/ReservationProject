package reservationapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ReservationAppConfig {

    public static void main(String[] args) {
        SpringApplication.run(ReservationAppConfig.class, args);
    }

}