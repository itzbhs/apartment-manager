/**
 * @author Henry Sule
 * @version May 14 2024
 * This program will be the subclass "CommercialProperty" for the Property Management Program
 */

public class CommercialProperty extends Property {

	//attributes
    private static final int MINIMUMLEASE = 12; // Minimum lease term in months
    private boolean hasElevator;
    private int parkingSpots;
    private float parkingToll;
    private static int totalCommercialProperties;

    // Constructor
    public CommercialProperty(String propertyType, String address, int area, double monthlyRent, int occupants, 
    								boolean hasElevator, int parkingSpots, float parkingToll) {
        super(propertyType, address, units, monthlyRent, occupants);
        this.hasElevator = hasElevator;
        this.parkingSpots = parkingSpots;
        this.parkingToll = parkingToll;
        totalCommercialProperties++;
    }

    //no parameter Constructor
    public CommercialProperty() {
        super();
        this.hasElevator = false;
        this.parkingSpots = 0;
        this.parkingToll = 0.0f;
    }

    // Getters and setters for all attributes
    // toString() method
    // Additional methods
    public double propertyValue() {
        // Add logic to calculate property value
        return 0.0; // Placeholder
    }

    public double parkingRevenue() {
        // Add logic to calculate parking revenue
        return 0.0; // Placeholder
    }
}
