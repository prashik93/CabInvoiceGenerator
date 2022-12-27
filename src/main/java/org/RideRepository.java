package org;

import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    Map<Integer, Ride[]> rideMap = new HashMap<>();

    public void addRides(int userId, Ride[] rides) {
        Ride[]  rideList = this.rideMap.get(userId);
        if(rideList == null) {
            this.rideMap.put(userId, rides);
        }
    }

    public Ride[] getRides(Integer userId) {
        return this.rideMap.get(userId);
    }
}
