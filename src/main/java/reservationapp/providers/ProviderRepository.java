package reservationapp.providers;

import org.springframework.stereotype.Repository;
import reservationapp.NotFoundException;
import reservationapp.providers.Provider;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProviderRepository {

    private Map<Integer, Provider> providers;

    public ProviderRepository() {
        providers = new HashMap();
        providers.put(1, new Provider(1, "Dr Jekyl"));
        providers.put(2, new Provider(2, "Doogie Howser M.D."));
        providers.put(3, new Provider(3, "Doctor Doom"));
    }

    public Collection<Provider> getProviders() {
        return providers.values();
    }

    public Provider getProviderById(int id) {
        Provider provider = providers.get(id);

        if (provider == null) {
            throw new NotFoundException("Provider", id);
        }

        return provider;
    }
}
