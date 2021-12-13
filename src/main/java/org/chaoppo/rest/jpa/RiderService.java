package org.chaoppo.rest.jpa;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RiderService {

    private static List<Rider> riders = new ArrayList<>();
    private static int usersCount = 3;

    static {
        riders.add(new Rider(1, "Stark"));
        riders.add(new Rider(2, "Lannister"));
        riders.add(new Rider(3, "Snow"));
    }

    public List<Rider> findAll() {
        return riders;
    }

    public Rider save(Rider rider) {
        if (rider.getId() == null) {
            rider.setId(++usersCount);
        }
        riders.add(rider);
        return rider;
    }

    public Rider find(int id) {
        for (Rider rider : riders) {
            if (rider.getId() == id) {
                return rider;
            }
        }
        return null;
    }

}
