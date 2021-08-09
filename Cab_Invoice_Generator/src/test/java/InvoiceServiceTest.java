import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Hashtable;

public class InvoiceServiceTest {

    InvoiceGenerator invoiceGenerator = null;

    @BeforeEach
    public void setUp() {
        invoiceGenerator = new InvoiceGenerator();
    }

    /************************************************************************************************************
     *
     * Purpose : Given distance and time, return total fare
     *
     ***********************************************************************************************************/

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assertions.assertEquals(25, fare);
    }

    /***********************************************************************************************************
     *
     * Purpose: Given distance and time, return minimum fare as 5
     *
     **********************************************************************************************************/

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assertions.assertEquals(5, fare);
    }

    /************************************************************************************************************
     *
     * Purpose : Given distance and time for multiple rides return the aggregate total for all the rides
     *
     ************************************************************************************************************/

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        Ride[] rides = {    new Ride(2.0, 5),
                            new Ride(0.1, 1)    };

        double fare = invoiceGenerator.calculateTotalFare(rides);
        Assertions.assertEquals(30, fare);
    }

    /************************************************************************************************************
     *
     * Purpose : Given distance and time, calculate the aggregate total for all the rides
     *           Finally calculate the average fare per ride
     *
     ***********************************************************************************************************/

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {    new Ride(2.0, 5),
                            new Ride(0.1, 1)    };

        InvoiceSummary summary = invoiceGenerator.calculateFareSummary(rides);
        InvoiceSummary expectdInvoiceSummary = new InvoiceSummary(2, 30);
        Assertions.assertEquals(expectdInvoiceSummary, summary);
    }

    /***********************************************************************************************************
     *
     * Purpose : Given userID,
     *           calculate the aggregate total for all the rides
     *           calculate the average fare per ride
     *           return the final invoice for that particular userID
     *           
     **********************************************************************************************************/

    @Test
    public void givenUserID_ShouldReturnInvoiceSummary() {
        Hashtable<Integer, Ride[]> htable = new Hashtable<>();

        int userID1 = 1;
        Ride[] ride1 = { new Ride(2.0, 5),
                new Ride(0.1, 1) };
        htable.put(userID1, ride1);

        int userID2 = 2;
        Ride[] ride2 = { new Ride(4.0, 10),
                new Ride(1, 1) };
        htable.put(userID2, ride2);

        int userID = 2;

        if(htable.containsKey(userID)) {
            InvoiceSummary summary = invoiceGenerator.calculateFareSummary(htable.get(userID));
            InvoiceSummary expectdInvoiceSummary = new InvoiceSummary(2, 61);
            Assertions.assertEquals(expectdInvoiceSummary, summary);
        }
    }
}
