/**
 * @author Henry Sule
 * @version May 14 2024
 * This program will be the subclass "Studio" for the Property Management Program
 */

public class Studio extends Property {

    private boolean hasKitchen;
    private boolean hasStorage;
    private boolean furnished; 
    private String style; //Can be either Style A, B, C



    // Parameterized constructor
    public Studio(float area, double monthlyRent, Tenant tenant, boolean hasKitchen, boolean hasStorage,  boolean furnished, String style) {

        super(area, monthlyRent);
        this.hasKitchen = hasKitchen;
        this.hasStorage = hasStorage;
        this.furnished = furnished;
        this.style = style;

        //Checking input for Style
	    try {
	        if (style.matches("Style\\s+[ABC]")) {
	            this.style = style;
	        } else {
	            throw new IllegalArgumentException("Style must be either Style A, Style B, or Style C.");
	        }
	    } catch (IllegalArgumentException e) {
	        System.out.println("Error: " + e.getMessage());
	    }


    }

    // No-parameter constructor
    public Studio(){
        super(200,1.0);
        this.hasKitchen = false;
        this.hasStorage = false;
        this.furnished = false;
        this.style = "";

    }

    // Getters and setters

    public boolean getFurnished(){
        return furnished;
    }

    public void setFurnished(boolean furnished){
        this.furnished = furnished;
    }

    public boolean getHasKitchen(){
        return hasKitchen;
    }

    public void setHasKitchen(boolean hasKitchen){
        this.hasKitchen = hasKitchen;
    }


    public boolean getHasStorage(){
        return hasStorage;
    }

    public void setHasStorage(boolean hasStorage){
        this.hasStorage = hasStorage;
    }


    public String getStyle(){
    	return style;
    }

    public void setStyle(String style){
    	try {
	        if (style.matches("Style\\s+[ABC]")) {
	            this.style = style;
	        } else {
	            throw new IllegalArgumentException("Style must be either Style A, Style B, or Style C.");
	        }
	    } catch (IllegalArgumentException e) {
	        System.out.println("Error: " + e.getMessage());
	    }
    }


    //Overridden methods
    @Override
    public double calculateMonthlyRevenue() { 
        return getMonthlyRent()+ calculateFees();
    }	

    // Method to calculate property value
    @Override
    public double calculatePropertyValue() { 
        return calculateMonthlyRevenue() * 12; 
    }

    //toString
	@Override
	public String toString() {
	    return String.format("Studio Property%n%s%nFurnished: %s%nHas Kitchen: %s%nHas Storage: %s%nStyle: %s%nMonthly Revenue: $%.2f%nProperty Value: $%.2f%nOther Fees: $%.2f%nUpgrade Price Available: $%.2f",
	            super.toString(), furnished, hasKitchen, hasStorage, style, calculateMonthlyRevenue(), calculatePropertyValue(), calculateFees(), upgradeStudio()); //
	}

    //Class-specific methods

    //Shows financial options for upgrading a studio based on studio size
    public double upgradeStudio() {
	   	double potentialRentIncrease = 0;
	    if (getArea() < 400) {
	        potentialRentIncrease = 50; //Potential rent increase for small studios
	    } else if (getArea() >= 400 && getArea() < 600) {
	        potentialRentIncrease = 100; //Potential rent increase for medium-sized studios
	    } else {
	        potentialRentIncrease = 200; //Potential rent increase for large studios
	    }

	    return potentialRentIncrease;
    }

    //calculate additional fees/costs based on specific additions
	public double calculateFees() {
	    double fees = 0.0;

	    if (hasKitchen) {
	        fees += 50;
	    }
	    if (hasStorage) {
	        fees += 23.50;
	    }
	    if (furnished) {
	        fees += 112.98;
	    }

	    return fees;
	}
}