package cabinvoicegeneratortest;

import org.CabInvoiceGenerator;
import org.InvoiceSummary;
import org.Ride;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
    CabInvoiceGenerator cabInvoiceGenerator = null;

    @Before
    public void setUp() throws Exception {
        cabInvoiceGenerator = new CabInvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFareForNormalRide() {
        String rideType = "Normal";
        double distance = 2.0;
        int time = 5;
        double fare = cabInvoiceGenerator.calculateFare(distance, time, rideType);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinFareForNormalRide() {
        String rideType = "Normal";
        double distance = 0.1;
        int time = 1;
        double fare = cabInvoiceGenerator.calculateFare(distance, time, rideType);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFareForPremiumRide() {
        String rideType = "Premium";
        double distance = 2.0;
        int time = 5;
        double fare = cabInvoiceGenerator.calculateFare(distance, time, rideType);
        Assert.assertEquals(40, fare, 0.0);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinFareForPremiumRide() {
        String rideType = "Premium";
        double distance = 0.1;
        int time = 1;
        double fare = cabInvoiceGenerator.calculateFare(distance, time, rideType);
        Assert.assertEquals(20, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummaryForNormalRide() {
        String rideType = "Normal";
        Ride[] rides = {new Ride(2.0, 5, rideType), new Ride(0.1, 1, rideType)};
        InvoiceSummary actualInvoiceSummary = cabInvoiceGenerator.calculateFare(rides, rideType);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30, rideType);
        Assert.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummaryForPremiumRide() {
        String rideType = "Premium";
        Ride[] rides = {new Ride(2.0, 5, rideType), new Ride(0.1, 1, rideType)};
        InvoiceSummary actualInvoiceSummary = cabInvoiceGenerator.calculateFare(rides, rideType);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 60, rideType);
        Assert.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
    }

    @Test
    public void givenUserId_ShouldReturnInvoiceSummaryForNormalRide() {
        String rideType = "Normal";
        int userId = 1;
        Ride[] rides = {new Ride(2.0, 5, rideType), new Ride(0.1, 1, rideType)};
        cabInvoiceGenerator.addRides(userId, rides);
        InvoiceSummary actualInvoiceSummary = cabInvoiceGenerator.getRides(userId, rideType);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30, rideType);
        Assert.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
    }

    @Test
    public void givenUserId_ShouldReturnInvoiceSummaryForPremiumRide() {
        String rideType = "Premium";
        int userId = 1;
        Ride[] rides = {new Ride(2.0, 5, rideType), new Ride(0.1, 1, rideType)};
        cabInvoiceGenerator.addRides(userId, rides);
        InvoiceSummary actualInvoiceSummary = cabInvoiceGenerator.getRides(userId, rideType);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 60, rideType);
        Assert.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
    }

}
