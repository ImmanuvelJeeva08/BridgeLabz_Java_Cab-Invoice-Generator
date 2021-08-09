import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
