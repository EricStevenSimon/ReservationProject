package reservationapp.providers;

import org.springframework.web.bind.annotation.*;
import reservationapp.appointments.AppointmentSlot;
import reservationapp.appointments.AppointmentSlotService;
import reservationapp.providers.Provider;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@RestController
public class ProvidersController {

    private ProviderRepository providerRepository;
    private AppointmentSlotService appointmentSlotService;

    public ProvidersController(ProviderRepository providerRepository,
                               AppointmentSlotService appointmentSlotService) {
        this.providerRepository = providerRepository;
        this.appointmentSlotService = appointmentSlotService;
    }

    @GetMapping("/providers")
    public Collection<Provider> getProviders() {

        Collection<Provider> providers = providerRepository.getProviders();
        return providers;
    }

    @GetMapping("/providers/{providerId}/appointmentSlots")
    public Collection<AppointmentSlot> getAppointmentSlots(@PathVariable int providerId) {

        Provider provider = providerRepository.getProviderById(providerId);
        Collection<AppointmentSlot> appointmentSlots = appointmentSlotService.getAppointmentSlotsForProvider(provider);
        return appointmentSlots;
    }

    @PostMapping("/providers/{providerId}/appointmentSlots")
    public void addAppointmentSlots(@PathVariable int providerId, @RequestBody ArrayList<LocalDateTime> appointmentTimesToAdd) {

        Provider provider = providerRepository.getProviderById(providerId);
        appointmentSlotService.addAppointmentSlots(provider, appointmentTimesToAdd);
    }

    @GetMapping("/providers/{providerId}/availableAppointmentSlots")
    public Collection<AppointmentSlot> getAvailableAppointmentSlots(@PathVariable int providerId) {

        Provider provider = providerRepository.getProviderById(providerId);
        Collection<AppointmentSlot> availableAppointmentSlots = appointmentSlotService.getAvailableAppointmentSlotsForProvider(provider);
        return availableAppointmentSlots;
    }
}
