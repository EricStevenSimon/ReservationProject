package reservationapp;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import reservationapp.appointments.AppointmentSlot;
import reservationapp.appointments.AppointmentSlotService;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

@Service
public class ReservationExpirationJob {

    public final AppointmentSlotService appointmentSlotService;

    public ReservationExpirationJob(AppointmentSlotService appointmentSlotService) {
        this.appointmentSlotService = appointmentSlotService;
    }

    //Looks for appointment slots which have been reserved, but weren't confirmed within that timeframe.  Frees
    //those slots up (and it would ideally also communicate this with the client).
    //Runs every minute
    @Scheduled(fixedRate = 10, timeUnit = TimeUnit.SECONDS)
    public void executeJob() {
        System.out.println("Running job");

        Collection<AppointmentSlot> overdueAppointmentSlots = appointmentSlotService.getAppointmentSlotsWithOverdueReservations();
        for (AppointmentSlot overdueSlot: overdueAppointmentSlots) {
            appointmentSlotService.cancelReservation(overdueSlot);
        }
    }
}
