/**
 * @author Henry Sule
 * @version May 14 2024
 * This program will be the superclass "Property" for the Property Management Program
 */

import java.util.Arrays;

public abstract class Property {

	//attributes

    private float area;
    protected double monthlyRent;
	private final String[] AMENITIES = {"24/7 Gym", "Dog Park", "Lounge", "Conference Room", "Pool"};
    protected static int occupiedUnits = 0; 
    private static Tenant tenant;

    // Constructor
    public Property(float area, double monthlyRent) {

        //exception handing for area
	    try {
	        if (area > 0) {
	            this.area = area;
	        } else {
	            throw new IllegalArgumentException("Area must be greater than 0.");
	        }
	    } catch (IllegalArgumentException e) {
	        System.out.println("Error: " + e.getMessage());
	    }

        //Exception handling for monthly rent
	    try {
	        if (monthlyRent > 0) {
	            this.monthlyRent = monthlyRent;
	        } else {
	            throw new IllegalArgumentException("Monthly rent must be greater than 0.");
	        }
	    } catch (IllegalArgumentException e) {
	        System.out.println("Error: " + e.getMessage());
	    }

	    this.tenant = tenant;
        occupiedUnits++; //keeps track of and adds a new occupied unit each time one is instantiated

    }

    //no parameter Constructor
    public Property() {
        this.area = 200;
        this.monthlyRent = 1.0;

        occupiedUnits++;
    }

    // Getters and setters for all attributes


    public float getArea() {
        return area;
    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
    public void setArea(float area) {
        try {
	        if (area > 0) {
	            this.area = area;
	        } else {
	            throw new IllegalArgumentException("Area must be greater than 0.");
	        }
	    } catch (IllegalArgumentException e) {
	        System.out.println("Error: " + e.getMessage());
	    }
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(double monthlyRent) {
        try {
	        if (monthlyRent > 0) {
	            this.monthlyRent = monthlyRent;
	        } else {
	            throw new IllegalArgumentException("Monthly rent must be greater than 0.");
	        }
	    } catch (IllegalArgumentException e) {
	        System.out.println("Error: " + e.getMessage());
	    }
    }

  	public String[] getAMENITIES() {
        return AMENITIES;
    }

    public static int getOccupiedUnits() {
        return occupiedUnits;
    }

    //Tenant composition class specific methods
    //Getter for tenant
    public Tenant getTenant() {
        return tenant;
    }

    // Setter for tenant
    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }


    // toString() method
	public String toString() {
    	return String.format("Property Details:%nArea: %.2f sq.ft%nMonthly Rent: $%.2f%nOccupied Units: %d%nAmenities: %s", area, monthlyRent, occupiedUnits, Arrays.toString(AMENITIES));
}


    // Abstract methods
    public abstract double calculateMonthlyRevenue(); //calculates monthly revenue based on rent and other fees                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            ;
    public abstract double calculatePropertyValue(); //calculates property value based on a 12 year time frame, estimating rent to be collected and any other fees
}