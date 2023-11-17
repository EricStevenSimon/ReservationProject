package reservationapp.appointments;

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

    public static AppointmentSlot createSampleHardcodedAppointmentSlot() {
        var sampleAppointment = new AppointmentSlot();
        sampleAppointment.providerId = 1;
        sampleAppointment.startTime = LocalDateTime.of(2023, 11, 17, 15, 00);
        sampleAppointment.id = UUID.fromString("00000000-0000-0000-0000-000000000000");
        sampleAppointment.bookingStatus = AppointmentBookingStatus.UNBOOKED;
        return sampleAppointment;
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

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setBookingStatus(AppointmentBookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
