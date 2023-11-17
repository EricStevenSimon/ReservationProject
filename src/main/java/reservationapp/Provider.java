package reservationapp;

import java.util.UUID;

public class Provider {

    public Provider() {
    }

    public Provider(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //using an int for the id for simplicity.  Would typically use uuids.
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
