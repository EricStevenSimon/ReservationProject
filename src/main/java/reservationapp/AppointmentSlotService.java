package reservationapp;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;

@Service
public class AppointmentSlotService {

    private AppointmentSlotRepository appointmentSlotRepository;

    public AppointmentSlotService(AppointmentSlotRepository appointmentSlotRepository) {
        this.appointmentSlotRepository = appointmentSlotRepository;
    }

    public Collection<AppointmentSlot> getAppointmentSlotsForProvider(Provider provider) {
        return appointmentSlotRepository.getAppointmentsForProvider(provider);
    }

    public void addAppointmentSlots(Provider provider, Collection<LocalDateTime> appointmentTimeSlotsToAdd) {

        //todo validation

        Collection<AppointmentSlot> appointmentsToAdd = appointmentTimeSlotsToAdd.stream()
                .map(appointmentTime -> new AppointmentSlot(provider.getId(), appointmentTime))
                .toList();
        appointmentSlotRepository.addAppointments(provider, appointmentsToAdd);
    }
}
