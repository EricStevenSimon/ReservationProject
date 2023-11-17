package reservationapp;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class AppointmentsController {

    private final AppointmentSlotService appointmentSlotService;

    public AppointmentsController(AppointmentSlotService appointmentSlotService) {
        this.appointmentSlotService = appointmentSlotService;
    }

    @PostMapping("/appointmentSlots/{appointmentId}/reserve")
    public void reserveAppointmentSlot(@PathVariable UUID appointmentId, @RequestBody ReservationRequest reservationRequest) {

        AppointmentSlot appointmentSlot = appointmentSlotService.getAppointmentSlotById(appointmentId);
        appointmentSlotService.reserveSlot(appointmentSlot, reservationRequest.getClientId());
    }

    @PostMapping("/appointmentSlots/{appointmentId}/confirm")
    public void confirmAppointmentSlot(@PathVariable UUID appointmentId) {

        //TODO add validation so that only reserved appointments can be confirmed
        AppointmentSlot appointmentSlot = appointmentSlotService.getAppointmentSlotById(appointmentId);
        appointmentSlotService.confirmSlot(appointmentSlot);
    }
}
