package reservationapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
