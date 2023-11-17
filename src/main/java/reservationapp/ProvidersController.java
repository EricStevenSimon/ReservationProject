package reservationapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ProvidersController {

    private ProviderRepository providerRepository;

    public ProvidersController(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @GetMapping("/providers")
    public Collection<Provider> getProviders() {

        Collection<Provider> providers = providerRepository.getProviders();
        return providers;
    }
}
