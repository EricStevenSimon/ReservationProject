package reservationapp;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class AppointmentsController {

    private AppointmentSlotService appointmentSlotService;

    public AppointmentsController(AppointmentSlotService appointmentSlotService) {
        this.appointmentSlotService = appointmentSlotService;
    }

    @PostMapping("/appointmentSlots/{appointmentId}/reserve")
    public void reserveAppointmentSlot(@PathVariable UUID appointmentId, @RequestBody ReservationRequest reservationRequest) {

        AppointmentSlot appointmentSlot = appointmentSlotService.getAppointmentSlotById(appointmentId);
        appointmentSlotService.reserveSlot(appointmentSlot, reservationRequest.getClientId());
    }
}
