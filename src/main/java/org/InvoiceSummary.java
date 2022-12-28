package org;

public class InvoiceSummary {

    public final int numOfRides;
    public final double totalFare;
    public final double averageFare;
    public final String rideType;

    public InvoiceSummary(int numOfRides, double totalFare, String rideType) {
        this.numOfRides = numOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare/this.numOfRides;
        this.rideType = rideType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return numOfRides == that.numOfRides && Double.compare(that.totalFare, totalFare) == 0 && Double.compare(that.averageFare, averageFare) == 0;
    }

    @Override
    public String toString() {
        return "InvoiceSummary{" +
                "numOfRides=" + numOfRides +
                ", totalFare=" + totalFare +
                ", averageFare=" + averageFare +
                ", rideType='" + rideType + '\'' +
                '}';
    }
}
