/**
 * @author Henry Sule
 * @version May 14 2024
 * This program will be the subclass "ResidentialProperty" for the Property Management Program
 */

public class ResidentialProperty extends Property {

	//attributes
    private boolean petsAllowed;
    private String[] amenities;
    private int managingStaff;
    private double monthlySalary;

    // Constructor
    public ResidentialProperty(String propertyType, String address, int area, double monthlyRent, int occupants,
                               boolean petsAllowed, String[] amenities, int managingStaff, double monthlySalary) {
        super(propertyType, address, area, monthlyRent, occupants);
        this.petsAllowed = petsAllowed;
        this.amenities = amenities;
        this.managingStaff = managingStaff;
        this.monthlySalary = monthlySalary;
    }

    //no parameter Constructor
    public ResidentialProperty() {
        super();
        this.petsAllowed = false;
        this.amenities = new String[0];
        this.managingStaff = 0;
        this.monthlySalary = 0.0;
    }

    // Getters and setters for all attributes
    // toString() method
    // Additional methods
    public double monthlyOperatingCost() {
        // Complete
        return 0.0; // Placeholder
    }

    public double monthlyRevenue() {
        // Complete
        return 0.0; // Placeholder
    }

    public double calculateMonthlyRevenue() {
    	//complete


    }


    public int availableUnits() {
    	//complete


    }
}
