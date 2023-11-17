package reservationapp;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class SampleJob {

    //Run every minute
    @Scheduled(fixedRate = 10, timeUnit = TimeUnit.SECONDS)
    public void executeJob() {
        System.out.println("executing job");
    }
}
