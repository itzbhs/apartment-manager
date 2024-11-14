/**
 *@author Henry Sule
 * @version May 14th 2024
 * This program will test the Property parent and sub classes
 */


import java.util.Scanner;

public class PropertyTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Test Studio and collect user input for instantiation
        System.out.println("Create a Studio:");
        System.out.println("Enter area:");
        float area = scanner.nextFloat();

        System.out.println("Enter monthly rent:");
        double monthlyRent = scanner.nextDouble();

        System.out.println("Does it have a kitchen? (true/false):");
        boolean hasKitchen = scanner.nextBoolean();

        scanner.nextLine(); // Prevent improper collection of user input
        System.out.println("Does it have storage? (true/false):");
		boolean hasStorage = scanner.nextBoolean();

		System.out.println("Is it furnished? (true/false):");
		boolean furnished = scanner.nextBoolean();

		scanner.nextLine(); // Prevent improper colelction of user input
		System.out.println("Enter style (Style A, Style B, Style C):");
		String style = scanner.nextLine();



        // Test tenant and collect user input for instantiation
		System.out.println("Enter tenant name:");
		String tenantName = scanner.nextLine();

		System.out.println("Enter tenant phone number (10 digit number, no spaces or dashes):");
		String tenantPhone = scanner.nextLine();

		System.out.println("Enter number of pets:");
		int tenantPets = scanner.nextInt();

		System.out.println("Enter lease duration (months):");
		int tenantLease = scanner.nextInt();

		//Create tenant
        Tenant tenant = new Tenant(tenantName, tenantPhone, tenantPets, tenantLease);

        // // Create Studio
        Studio studio = new Studio(area, monthlyRent, tenant, hasKitchen, hasStorage, furnished, style);

        //Print out newly created Studio 
        System.out.println(studio);

        //Print out newly created Tenant
        System.out.println(tenant);


		// Test TwoBedroom and collect user input
        System.out.println("Create a Two Bedroom:");

        System.out.println("Enter area:");
        area = scanner.nextFloat();

        System.out.println("Enter monthly rent:");
        monthlyRent = scanner.nextDouble();

        System.out.println("Enter number of bathrooms:");
        int bathrooms = scanner.nextInt();

        System.out.println("Does it have a balcony? (true/false):");
        boolean hasBalcony = scanner.nextBoolean();

        System.out.println("Does it have a garage? (true/false):");
        boolean hasGarage = scanner.nextBoolean();

        System.out.println("Enter floor from 1-6 (Enter as Floor __):");
        String floor = scanner.next();

        // Create Two Bedroom
        TwoBedroom twoBedroom = new TwoBedroom(area, monthlyRent, tenant, bathrooms, hasBalcony, hasGarage, floor);

        //Print out TwoBedrooom
        System.out.print(twoBedroom);

        //Test methods

        //Test Studio Methods
        tenant.fineTenant(); //fines tenant, issues a warning, and adds a strike to their account

        System.out.print(tenant); //This new output should show the tenant profile with a strike on their account

        twoBedroom.removeGarage(); //removes the garage from the property if there's one

        //All other methods are tested and printed during the output, toString calls

        // // Empty Constructors
        Property studio2 = new Studio();
        Property twoBedroom2 = new TwoBedroom();

        //Print empty constructors
        System.out.println(studio2);
        System.out.println(twoBedroom2);

        //Demonstrate Polymorphism:


        Property[] properties = {studio, twoBedroom};

        //Enhanced for loop accesses the calculateMonthlyRevenue method for both studio and twoBedroom, printing different outputs based on the class.
        for (Property property : properties) {
            System.out.println("Monthly revenue for Property is" + ": $" + property.calculateMonthlyRevenue());
        }

    }
    //Program complete
}