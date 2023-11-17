package reservationapp.appointments;

import org.springframework.stereotype.Service;
import reservationapp.providers.Provider;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

@Service
public class AppointmentSlotService {

    private AppointmentSlotRepository appointmentSlotRepository;

    public AppointmentSlotService(AppointmentSlotRepository appointmentSlotRepository) {
        this.appointmentSlotRepository = appointmentSlotRepository;
    }

    public AppointmentSlot getAppointmentSlotById(UUID id) {
        return appointmentSlotRepository.getAppointmentSlotById(id);
    }

    public Collection<AppointmentSlot> getAppointmentSlotsForProvider(Provider provider) {
        return appointmentSlotRepository.getAppointmentsForProvider(provider);
    }

    public Collection<AppointmentSlot> getAvailableAppointmentSlotsForProvider(Provider provider) {
        return appointmentSlotRepository.getAvailableAppointmentsForProvider(provider);
    }


    public void addAppointmentSlots(Provider provider, Collection<LocalDateTime> appointmentTimeSlotsToAdd) {

        //todo validation

        Collection<AppointmentSlot> appointmentsToAdd = appointmentTimeSlotsToAdd.stream()
                .map(appointmentTime -> new AppointmentSlot(provider.getId(), appointmentTime))
                .toList();
        appointmentSlotRepository.addAppointments(provider, appointmentsToAdd);
    }

    public void reserveSlot(AppointmentSlot appointmentSlot, int clientId) {
        //TODO verify client exists
        appointmentSlot.setClientId(clientId);
        appointmentSlot.setBookingStatus(AppointmentBookingStatus.RESERVATION_IN_PROGRESS);
        appointmentSlot.setReservationTime(LocalDateTime.now());
        //There should really be a call to "update" the change in the DB but, with the current lack of a DB,
        //updating the slot object which is in memory is sufficient to "persist" the change.
    }

    public void confirmSlot(AppointmentSlot appointmentSlot) {
        appointmentSlot.setBookingStatus(AppointmentBookingStatus.CONFIRMED);
        //There should really be a call to "update" the change in the DB but, with the current lack of a DB,
        //updating the slot object which is in memory is sufficient to "persist" the change.
    }

    public Collection<AppointmentSlot> getAppointmentSlotsWithOverdueReservations() {
        return appointmentSlotRepository.getAppointmentSlotsWithOverdueReservations();
    }

    public void cancelReservation(AppointmentSlot appointmentSlot) {
        appointmentSlot.setClientId(0);
        appointmentSlot.setReservationTime(null);
        appointmentSlot.setBookingStatus(AppointmentBookingStatus.UNBOOKED);
        //There should really be a call to "update" the change in the DB but, with the current lack of a DB,
        //updating the slot object which is in memory is sufficient to "persist" the change.
    }
}
