/**
 * @author Henry Sule
 * @version May 14 2024
 * This program will be the composition class "Tenant" for the Property Management Program
 */


public class Tenant {
    // Attributes
    private String name;
    private String phoneNum; //haven't implemented
    private int pets;
    private int lease;


    private int tenantRecord = 0; //used to keep tally of strikes against the tenant with a cap of 3
    private boolean flaggedTenant = false;

    // Constructor
    public Tenant(String name, String phoneNum, int pets, int lease) {
	    
    	//Name
	    try {
	        if (name.matches("[A-Z][a-z]+ [A-Z]\\D+")) {
	            this.name = name;
	        } else {
	            throw new IllegalArgumentException("Name must contain only letters.");
	        }
	    } catch (IllegalArgumentException e) {
	        System.out.println("Error: " + e.getMessage());
	    }

        //Phone Number

	    try {
	        if (phoneNum.matches("\\d{10}")) {
	            this.phoneNum = phoneNum;
	        } else {
	            throw new IllegalArgumentException("Phone number must be a 10-digit number.");
	        }
	    } catch (IllegalArgumentException e) {
	        System.out.println("Error: " + e.getMessage());
	    }

	    //Pets
	    try {
	        if (pets >= 0) {
	            this.pets = pets;
	        } else {
	            throw new IllegalArgumentException("Number of pets cannot be negative.");
	        }
	    } catch (IllegalArgumentException e) {
	        System.out.println("Error: " + e.getMessage());
	    }

	    //Lease
		try {
	        if (lease >= 6) {
	            this.lease = lease;
	        } else {
	            throw new IllegalArgumentException("Lease duration must be at least 6 months.");
	        }
	    } catch (IllegalArgumentException e) {
	        System.out.println("Error: " + e.getMessage());
	    }
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        try {
	        if (name.matches("[a-zA-Z]+")) {
	            this.name = name;
	        } else {
	            throw new IllegalArgumentException("Name must contain only letters.");
	        }
	    } catch (IllegalArgumentException e) {
	        System.out.println("Error: " + e.getMessage());
	    }
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        try {
	        if (phoneNum.matches("\\d{10}")) {
	            this.phoneNum = phoneNum;
	        } else {
	            throw new IllegalArgumentException("Phone number must be a 10-digit number.");
	        }
	    } catch (IllegalArgumentException e) {
	        System.out.println("Error: " + e.getMessage());
	    }
    }

    public int getPets() {
        return pets;
    }

    public void setPets(int pets) {
        try {
	        if (pets >= 0) {
	            this.pets = pets;
	        } else {
	            throw new IllegalArgumentException("Number of pets cannot be negative.");
	        }
	    } catch (IllegalArgumentException e) {
	        System.out.println("Error: " + e.getMessage());
	    }
    }

    public int getLease() {
        return lease;
    }

    public void setLease(int lease) {
        try {
	        if (lease >= 6) {
	            this.lease = lease;
	        } else {
	            throw new IllegalArgumentException("Lease duration must be at least 6 months.");
	        }
	    } catch (IllegalArgumentException e) {
	        System.out.println("Error: " + e.getMessage());
	    }
    }

    //Custom Methods

    // Method to display tenant details

    @Override
	public String toString() {
	    return String.format("Tenant Details:%nName: %s%nPhone Number: %s%nPets: %d%nLease Duration: %d months%nPet Fees: %.2f%nTenant Strikes: %d",
	            name, phoneNum, pets, lease, petFee(),tenantRecord);
	}


    //Calculate additional fee based on pets
    public double petFee(){
    	return 200+ getPets() * 35; //This accounts for a deposit plus a montly fee
    }

    public void fineTenant() {
    if (tenantRecord < 3) {
        tenantRecord++;
        System.out.println("This is an official warning that you have infringed on the policy of the property due to negligent, noncompliant, or destructive behavior.");
        System.out.println("You have been issued a warning. Once you reach 3 strikes, more drastic measures will be taken!");
    } else if (tenantRecord == 3) {
        tenantRecord++;
        System.out.println("This is your third and final warning. Further action will be taken against you if you continue to violate the property's policies.");
        System.out.println("Your tenancy is now flagged. Further violations may result in termination of the lease agreement.");
    } else {
        System.out.println("You have already received three warnings. Your tenancy is now flagged.");
        System.out.println("The termination of your lease aggreement is being processed and will be at your expense! You will also receive a negative referral from our manager.");
        flaggedTenant = true;
    }
}
}