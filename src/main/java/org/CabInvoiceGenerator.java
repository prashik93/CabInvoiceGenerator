package org;

public class CabInvoiceGenerator {
    private static final double NORMAL_RIDE_MINIMUM_COST_PER_KILOMETER = 10;
    private static final int NORMAL_RIDE_COST_PER_TIME = 1;
    private static final double NORMAL_RIDE_MINIMUM_FARE = 5;
    private static final double PREMIUM_RIDE_MINIMUM_COST_PER_KILOMETER = 15;
    private static final int PREMIUM_RIDE_COST_PER_TIME = 2;
    private static final double PREMIUM_RIDE_MINIMUM_FARE = 20;

    RideRepository rideRepository = new RideRepository();

    public double calculateFare(double distance, int time, String rideType) {
        if(rideType.equals("Normal")) {
            double totalFare = distance * NORMAL_RIDE_MINIMUM_COST_PER_KILOMETER + time * NORMAL_RIDE_COST_PER_TIME;
            if (totalFare < NORMAL_RIDE_MINIMUM_FARE)
                return NORMAL_RIDE_MINIMUM_FARE;
            return totalFare;
        }
        double totalFare = distance * PREMIUM_RIDE_MINIMUM_COST_PER_KILOMETER + time * PREMIUM_RIDE_COST_PER_TIME;
        if(totalFare < PREMIUM_RIDE_MINIMUM_FARE)
            return PREMIUM_RIDE_MINIMUM_FARE;
        return totalFare;
    }

    public InvoiceSummary calculateFare(Ride[] rides, String rideType) {
        double totalFare = 0;
        for(Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time, rideType);
        }
        return new InvoiceSummary(rides.length, totalFare, rideType);
    }

    public void addRides(int userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }

    public InvoiceSummary getRides(int userId, String rideType) {
        return this.calculateFare(rideRepository.getRides(userId), rideType);
    }

}
