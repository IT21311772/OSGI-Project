package item_publisher;

import java.util.Scanner;

public class ItemService implements ItemPublish{
    // Constants
    public static final String confirmText = "Y";
    public static final String declineText = "N";
    public static final int maxAttempts = 3;
    public static final String adminUsername = "admin";
    public static final String adminPassword = "admin123";
    
    // Appointment Arrays
    int[] itemIds = {1, 2, 3, 4, 5};
	int[] amount = {10, 11, 12, 13, 14};
	 String[] ItemName = {"Scissor", "Shampoo", "Conditioner", "Body Cream", "Shaving Cream"};
    String[] supplierId = {"S001", "S002", "S003", "S004", "S004"};
    String[] supplierName = {"Shiny Traders", "Star Lovers", "Galaxy Store", "Riza Traders", "Lizza Store"};
    String[] availableItem = {"Scissor", "Shampoo", "Conditioner", "Body Cream", "Shaving Cream"};
    String[] serviceCategory = {"H", "O", "H", "O", "B"};
    
   
    Scanner sc = new Scanner(System.in);

    public void supplierRegistration() {
            System.out.println("Enter Supplier ID : ");
            String supplierId = sc.next();
            
            System.out.println("Enter Supplier Name : ");
            String supplierName = sc.next();
            
            System.out.println("Enter Available Item : ");
            String availableItem = sc.next();
          
            
            System.out.println("You have successfully Complete the Supplier Registration");
            System.out.println("Supplier Details : ");
            System.out.println("Supplier ID : " + supplierId);
            System.out.println("Supplier Name : " + supplierName);
            System.out.println("Available Item : " + availableItem);
           
    }

	@Override
	public String getRole() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Do You want register as Supplier[Y - Yes || N - No] : ");
		String role = sc.next();
		
		return role;
	}

	@Override
	public void itemMain() {
		String role = getRole();

	    if ("N".equalsIgnoreCase(role)) {
	        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
		        Scanner user = new Scanner(System.in);
		        Scanner pwd = new Scanner(System.in);
		        
	            System.out.println("Enter Admin Username : ");
	            String username = user.next();

	            System.out.println("Enter Admin Password : ");
	            String password = pwd.next();
	            
	            boolean isValidated = validate(username, password);

	            if (isValidated == true) {
	                System.out.println("Authentication successful!");
	                Scanner sc = new Scanner(System.in);
	                
	                System.out.println("Enter [Y] to display the Items and Assign Suppliers/Enter [N] to Cancel : ");
	                String employeeConfirm = sc.next();
	                	
	                if(employeeConfirm.equalsIgnoreCase(confirmText)) {
	                	assignOrders();
	                } else if(employeeConfirm.equalsIgnoreCase(declineText)) {
	                	break;
	                } else {
	                	System.out.println("Invalid Character");
	                }
	                break;
	            } else {
	                System.out.println("Authentication failed. You have " + (maxAttempts - attempt) + " attempts remaining.");
	            }
	        }
	    } else if("Y".equalsIgnoreCase(role)) {
	    	supplierRegistration();
	    } else {
	    	System.out.println("Appointment Process Terminated");
	    }
		
	}

	@Override
	public boolean validate(String username, String password) {
		if(username.equals(adminUsername) && password.equals(adminPassword)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void displayItems() {
		System.out.println("Item Details");
		System.out.println(" ");
		for (int i = 0; i < 5; i++) {
	    	System.out.print("Item ID : " + itemIds[i] +  "\n");
	        System.out.print("Item Name : " + ItemName[i] + "\n");
	     }
		System.out.println("=============================================");
	}

	@Override
	public void displaySuppliers() {
		System.out.println("Supplier Details");
		System.out.println(" ");
		for(int i = 0; i < 3; i++) {
			System.out.print("Supplier ID : " + supplierId[i] + "\n");
	        System.out.print("Supplier Name : " + supplierName[i] + "\n");
	        System.out.print("Available Item : " + availableItem[i] + "\t \n");
	        System.out.print("Availabe Amount : " + amount[i] + "\t \n");
		}
		System.out.println("=============================================");
	}

	@Override
	public void assignOrders() {
	    int itemLength = itemIds.length;
	    int supplierLength = supplierId.length;
	    int i = 0;
	    
	    displayItems();
	    displaySuppliers();
	    
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the Item ID : ");
	    int itemNumber = sc.nextInt();
	    
	    while (i < itemLength) {
	        int j = 0;
	        
	        if (itemNumber == itemIds[i]) {
	            int attempts = 3; // Number of attempts allowed
	            while (attempts > 0) {
	                System.out.println("Enter the Supplier ID (Attempts left: " + attempts + "):");
	                String SupplierNumber = sc.next();
	                
	                while (j < supplierLength) {
	                    if (SupplierNumber.equals(supplierId[j])) {
	                        System.out.println(supplierName[j] + " is Going to supply item " + itemIds[j]);
	                        return; // Successful assignment, exit the method
	                    }
	                    j++;
	                }
	                
	                System.out.println("Supplier not found. Please Try Again.");
	                attempts--;
	                j = 0; // Resetting the index for employee array for the next attempt
	            }
	            // If attempts are exhausted and employee is still not found
	            System.out.println("Maximum attempts reached. Order canceled.");
	            return;
	        }
	        i++;
	    }
	    // If appointment is not found
	    System.out.println("Item not found.");
	}
}

