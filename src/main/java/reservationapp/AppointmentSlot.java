package reservationapp;

import java.time.LocalDateTime;
import java.util.UUID;

public class AppointmentSlot {

    private static final int DURATION_IN_MINUTES = 15;
    private int id;
    private int providerId;
    private int clientId;
    private LocalDateTime startTime;
    private AppointmentBookingStatus bookingStatus;
}
