package reservationapp.appointments;

import org.springframework.stereotype.Component;
import reservationapp.ValidationException;

import java.time.LocalDateTime;
import java.util.Collection;

@Component
public class AppointmentSlotValidator {

    public void validateAddAppointmentSlots(Collection<AppointmentSlot> appointmentSlots) {

        //todo add validation. Likely want to enforce that all appointments have to begin top of the hour, fifteen minutes
        //into the hour, etc.  Also need to handle duplicates.
    }

    public void validateReservation(AppointmentSlot slotToReserve) {

        LocalDateTime twentyFourHoursFromNow = LocalDateTime.now().plusDays(1);
        if (slotToReserve.getStartTime().isBefore(twentyFourHoursFromNow)) {
            throw new ValidationException("Reservation must be at least twenty-four hours from now");
        }
    }
}
