/****************************************************************************************************************
 *
 * Purpose : Given distance and time, Return total fare for the journey
 *
 * Condition : If minimum total fare is less than the MINIMUM_FARE, return MINIMUM_FARE
 *
 * @author : Immanuvel Jeeva
 * @Since  : 09-08-2021
 *
 ***************************************************************************************************************/
public class InvoiceGenerator {

    private static final double MINIMUM_COST_PER_KM = 10.0;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5;


    public double calculateFare(double distance, int time) {

        double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    /***********************************************************************************************************
     *
     * Purpose : Given distance and time for multiple rides, Return aggregate total fare for all the journey
     *
     **********************************************************************************************************/

    public double calculateTotalFare(Ride[] rides) {

        double totalFare = 0.0;
        for(Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }
}
