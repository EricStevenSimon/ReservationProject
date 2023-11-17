package reservationapp;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AppointmentSlotRepository {

    private Map<Integer, Collection<AppointmentSlot>> appointmentsByProvider;

    public AppointmentSlotRepository() {
        this.appointmentsByProvider = new HashMap<>();
        //hard coding initial provider data into the map.
        appointmentsByProvider.put(1, new ArrayList<>());
        appointmentsByProvider.put(2, new ArrayList<>());
        appointmentsByProvider.put(3, new ArrayList<>());
    }

    public Collection<AppointmentSlot> getAppointmentsForProvider(Provider provider) {

        return appointmentsByProvider.get(provider.getId());
    }
}