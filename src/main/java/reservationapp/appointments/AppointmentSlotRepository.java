package reservationapp.appointments;

import org.springframework.stereotype.Repository;
import reservationapp.NotFoundException;
import reservationapp.providers.Provider;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class AppointmentSlotRepository {

    private Map<Integer, Collection<AppointmentSlot>> appointmentsByProvider;
    private Map<UUID, AppointmentSlot> appointmentSlotsById;

    public AppointmentSlotRepository() {
        appointmentsByProvider = new HashMap<>();
        //hard coding initial provider data into the map.
        appointmentsByProvider.put(1, new ArrayList<>());
        appointmentsByProvider.put(2, new ArrayList<>());
        appointmentsByProvider.put(3, new ArrayList<>());

        appointmentSlotsById = new HashMap<>();

        var sampleAppointment = AppointmentSlot.createSampleHardcodedAppointmentSlot();
        appointmentsByProvider.get(sampleAppointment.getProviderId()).add(sampleAppointment);
        appointmentSlotsById.put(sampleAppointment.getId(), sampleAppointment);
    }

    public Collection<AppointmentSlot> getAppointmentsForProvider(Provider provider) {

        return appointmentsByProvider.get(provider.getId());
    }

    public Collection<AppointmentSlot> getAvailableAppointmentsForProvider(Provider provider) {

        return appointmentsByProvider.get(provider.getId())
                .stream()
                .filter(slot -> slot.getBookingStatus() == AppointmentBookingStatus.UNBOOKED)
                .toList();
    }

    public AppointmentSlot getAppointmentSlotById(UUID id) {
        AppointmentSlot slot = appointmentSlotsById.get(id);

        if (slot == null) {
            throw new NotFoundException("Appointment Slot", id);
        }

        return slot;
    }

    public Collection<AppointmentSlot> getAppointmentSlotsWithOverdueReservations() {
        //Taking a quick approach to this and using the map of "appointment slots by id" to get all possible
        //appointments, then doing some quick in-memory filtering.

        //A reservation is considered as "overdue" if it is unconfirmed within thirty minutes
        LocalDateTime thirtyMinutesAgo = LocalDateTime.now().minusMinutes(30);
        return appointmentSlotsById.values().stream()
                .filter(slot -> slot.getBookingStatus() == AppointmentBookingStatus.RESERVATION_IN_PROGRESS && slot.getReservationTime().isBefore(thirtyMinutesAgo))
                .toList();

    }

    public void addAppointments(Provider provider, Collection<AppointmentSlot> appointments) {

        //Add to "provider" map
        Collection<AppointmentSlot> appointmentSlotsForProvider = getAppointmentsForProvider(provider);
        appointmentSlotsForProvider.addAll(appointments);

        //add to "by id" map
        for (AppointmentSlot appointment: appointments) {
            appointmentSlotsById.put(appointment.getId(), appointment);
        }
    }
}
