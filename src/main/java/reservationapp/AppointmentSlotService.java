package reservationapp;

import org.springframework.stereotype.Service;

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
}
