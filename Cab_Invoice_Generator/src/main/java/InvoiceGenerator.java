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

    private static final int NORMALRIDE = 1;
    private static final int PREMIUMRIDE = 2;
    private static double MINIMUM_COST_PER_KM = 0.0;
    private static int COST_PER_TIME = 0;
    private static double MINIMUM_FARE = 0;


    public double calculateFare(double distance, int time , int option) {

        if(option == NORMALRIDE) {
            MINIMUM_COST_PER_KM = 10.0;
            COST_PER_TIME = 1;
            MINIMUM_FARE = 5;
        }

        else if(option == PREMIUMRIDE) {
            MINIMUM_COST_PER_KM = 15.0;
            COST_PER_TIME = 2;
            MINIMUM_FARE = 20;
        }

        double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    /***********************************************************************************************************
     *
     * Purpose : Given distance and time for multiple rides, Return aggregate total fare for all the journey
     *
     **********************************************************************************************************/

    public double calculateTotalFare(Ride[] rides, int option) {

        double totalFare = 0.0;
        for(Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time, option);
        }
        return totalFare;
    }

    /***********************************************************************************************************
     *
     * Purpose : Given distance and time for multiple rides,
     *           Calculate aggregate total fare for all the journey
     *           Calculate the average fare per ride taking total number of rides and total fare as input
     *
     **********************************************************************************************************/

    public InvoiceSummary calculateFareSummary(Ride[] rides, int option) {
        double totalFare = 0.0;
        for(Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time, option);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }
}
