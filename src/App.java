import java.util.Scanner;

/*
 * LogiNext Delivery Assignment System
 * ------------------------------------
 * This program assigns delivery drivers to customer orders
 * based on order time and driver availability.
 * 
 * Rules:
 * 1. Each driver can handle one order at a time.
 * 2. Lowest indexed available driver is assigned first.
 * 3. If no driver is available, print "No Food :-(".
 */

class Driver {

    private int id;
    private int availableAt;  // Time when driver becomes free

    // Constructor
    public Driver(int id) {
        this.id = id;
        this.availableAt = 0;  // Initially free at time 0
    }

    // Check if driver is available at given time
    public boolean isAvailable(int orderTime) {
        return orderTime >= availableAt;
    }

    // Assign order and update next available time
    public void assignOrder(int orderTime, int travelTime) {
        this.availableAt = orderTime + travelTime;
    }

    public int getId() {
        return id;
    }
}

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter N (orders) and M (drivers): ");
        int totalOrders = scanner.nextInt();
        int totalDrivers = scanner.nextInt();

        int[] orderTimes = new int[totalOrders];
        int[] travelTimes = new int[totalOrders];

        System.out.println("Enter order time and travel time for each customer:");

        for (int i = 0; i < totalOrders; i++) {
            orderTimes[i] = scanner.nextInt();
            travelTimes[i] = scanner.nextInt();
        }

        // Initialize drivers
        Driver[] drivers = new Driver[totalDrivers];
        for (int i = 0; i < totalDrivers; i++) {
            drivers[i] = new Driver(i + 1);
        }

        // Process each order
        for (int i = 0; i < totalOrders; i++) {

            boolean orderAssigned = false;

            for (int j = 0; j < totalDrivers; j++) {

                if (drivers[j].isAvailable(orderTimes[i])) {

                    drivers[j].assignOrder(orderTimes[i], travelTimes[i]);

                    System.out.println("C" + (i + 1) + " - D" + drivers[j].getId());

                    orderAssigned = true;
                    break;  // Assign lowest indexed available driver
                }
            }

            if (!orderAssigned) {
                System.out.println("C" + (i + 1) + " - No Food :-(");
            }
        }

        scanner.close();
    }
}
