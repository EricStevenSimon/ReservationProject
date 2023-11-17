package reservationapp;

import java.time.LocalDateTime;
import java.util.UUID;

public class AppointmentSlot {

    private static final int DURATION_IN_MINUTES = 15;
    private UUID id;
    private int providerId;
    private int clientId;
    private LocalDateTime startTime;
    private AppointmentBookingStatus bookingStatus;

    public AppointmentSlot() {
    }

    public AppointmentSlot(int providerId, LocalDateTime startTime) {
        this.providerId = providerId;
        this.startTime = startTime;
        //All new appointments start as unbooked
        bookingStatus = AppointmentBookingStatus.UNBOOKED;
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public int getProviderId() {
        return providerId;
    }

    public int getClientId() {
        return clientId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public AppointmentBookingStatus getBookingStatus() {
        return bookingStatus;
    }
}
