/**
 * @author Henry Sule
 * @version May 14 2024
 * This program will be the subclass "Two Beddroom" for the Property Management Program
 */

public class TwoBedroom extends Property {
    // Additional variables

    private int bathrooms;
    private boolean hasBalcony;
    private boolean hasGarage; 
    private String floor; //Can be floor 1 - 6

    // Constructors
    public TwoBedroom(float area, double monthlyRent, Tenant tenant, int bathrooms, boolean hasBalcony, boolean hasGarage, String floor) {
        super(area, monthlyRent);
        
        //Exception handling for bathroom
	    try {
	        if (bathrooms >= 1) {
	            this.bathrooms = bathrooms;
	        } else {
	            throw new IllegalArgumentException("Number of bathrooms must be at least 1.");
	        }
	    } catch (IllegalArgumentException e) {
	        System.out.println("Error: " + e.getMessage());
	    }

       	this.hasBalcony = hasBalcony;
        this.hasGarage = hasGarage;
        

        //Exception handling for floor
	    try {
	        if (floor.matches("Floor\\s+[1-6]")) {
	            this.floor = floor;
	        } else {
	            throw new IllegalArgumentException("Floor must be between floor 1 and floor 6.");
	        }
	    } catch (IllegalArgumentException e) {
	        System.out.println("Error: " + e.getMessage());
	    }

    }

    public TwoBedroom() {
        super(200, 1.0);
        this.bathrooms = 1;
        this.hasBalcony = false;
        this.hasGarage = false;
        this.floor = "";


    }

    // Getters and setters

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        //Exception handling for bathroom
	    try {
	        if (bathrooms >= 1) {
	            this.bathrooms = bathrooms;
	        } else {
	            throw new IllegalArgumentException("Number of bathrooms must be at least 1.");
	        }
	    } catch (IllegalArgumentException e) {
	        System.out.println("Error: " + e.getMessage());
	    }
    }

    public boolean hasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }


    public boolean gethasGarage() {
        return hasGarage;
    }

    public void setHasGarage(boolean hasGarage) {
        this.hasGarage = hasGarage;
    }


    public String getFloor(){
    	return floor;
    }

    public void setFloor(){

    	//Exception handling for floor
	    try {
	        if (floor.matches("Floor\\s+[1-6]")) {
	            this.floor = floor;
	        } else {
	            throw new IllegalArgumentException("Floor must be between floor 1 and floor 6.");
	        }
	    } catch (IllegalArgumentException e) {
	        System.out.println("Error: " + e.getMessage());
	    }
    }


    //Overridden methods
    @Override
    public double calculateMonthlyRevenue() {
    	double fees = 0.0;

    	//add additional fees based on possible additions
	   	if (hasGarage) {
	        fees += 100;
	    }
	    if (hasBalcony) {
	        fees += 20.12;
	    }

        return getMonthlyRent() + getUtilities() + fees + getBathrooms()*78;//additional cost for each bathroom
    }	

    // Method to calculate property value
    @Override
    public double calculatePropertyValue() {
        return calculateMonthlyRevenue() * 12; 
    }

    // toString() method
	@Override
	public String toString() {
	    return String.format("Two Bedroom Property%n%s%nBathrooms: %d%nHas Balcony: %s%nHas Garage: %s%nFloor: %s%nMonthly Revenue: $%.2f%nProperty Value: $%.2f%nUtilities: $%.2f",
	            super.toString(), bathrooms, hasBalcony, hasGarage, floor, calculateMonthlyRevenue(), calculatePropertyValue(), getUtilities());
	}

    // Class-specific methods
    public void removeGarage(){ //removes the garage from the property, at the same time reducing cost.
    	setHasGarage(false);
    	System.out.println("The Garage has been removed from the property and the fee reduced by $100.");
    }

    public final double getUtilities(){ //calculate utilities for the two bedroom property

    	double cost = 0.0; //calculate/estimate utilities based on general factors

    	cost += getBathrooms()*3*4; //calculate an estimate of $3 per week for 4 weeks based on number of bathrooms

    	cost += getArea() * 0.065; //calculate estimate of additional utilites (electricity perhaps) based on square footage of apartment

    	cost += 13.26; //garbage and other miscellaneous fees

    	return cost;
    }



}
