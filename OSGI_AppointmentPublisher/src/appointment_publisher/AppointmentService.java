package appointment_publisher;
import java.util.*;

public class AppointmentService implements AppointmentPublish{
    // Constants
    public static final String confirmText = "Y";
    public static final String declineText = "N";
    public static final int maxAttempts = 3;
    public static final String adminUsername = "admin";
    public static final String adminPassword = "admin123";
    
    // Appointment Arrays
    int[] appointmentIds = {1, 2, 3, 4, 5};
	int[] timeSlots = {10, 11, 12, 13, 14};
    String[] customerNames = {"Eranda", "Sewmini", "Shamal", "Uwani", "Anupa"};
    char[] gender = {'M', 'F', 'M', 'F', 'M'};
    String[] service = {"Hair Cut", "Facial", "Hair Cut", "Clean Up", "Beard Cut"};
    String[] serviceCategory = {"H", "O", "H", "O", "B"};
    
    // Employee Arrays
    int[] eid = {21, 22, 23};
	String[] employeeName = {"Dualj", "Nuwandi", "Kushan"};
	String[] specialization = {"Hair", "Beard", "Others"};
    
    Scanner sc = new Scanner(System.in);

    public void makeAppointment() {
            System.out.println("Enter Your Name : ");
            String customerName = sc.next();
            
            System.out.println("Enter Your Gender(M - Male / F - Female) : ");
            String customerGender = sc.next();
            
            System.out.println("Enter Your Service : ");
            String customerService = sc.next();
            
            System.out.println("You have successfully made your Appointment");
            System.out.println("Your Appointment Details : ");
            System.out.println("Customer Name : " + customerName);
            System.out.println("Gender : " + customerGender);
            System.out.println("Service : " + customerService);
    }

	@Override
	public String getRole() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Do You want make an Appointment[Y - Yes || N - No] : ");
		String role = sc.next();
		
		return role;
	}

	@Override
	public void appointmentMain() {
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
	                
	                System.out.println("Enter [Y] to display the Current Appointments and Assign Employees/Enter [N] to Cancel : ");
	                String employeeConfirm = sc.next();
	                	
	                if(employeeConfirm.equalsIgnoreCase(confirmText)) {
	                	assignEmployees();
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
	    	makeAppointment();
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
	public void displayAppointments() {
		for (int i = 0; i < 5; i++) {
	    	System.out.print("Appointment ID : " + appointmentIds[i] +  "\t");
	        System.out.print("Customer Name : " + customerNames[i] + "\t");
	        System.out.print("Gender : " + gender[i] + "\t");
	        System.out.print("Service : " + service[i] + "\t");
	        System.out.print("Service Category : " + serviceCategory[i] + "\t");
	        System.out.print("Allocated Time : " + timeSlots[i] + "\t \n");
	     }
		System.out.println();
	}

	@Override
	public void displayEmployees() {
		for(int i = 0; i < 3; i++) {
			System.out.print("Employee ID : " + eid[i] + "\t");
	        System.out.print("Employee Name : " + employeeName[i] + "\t");
	        System.out.print("Specialization : " + specialization[i] + "\t \n");
		}
		System.out.println();
	}

	@Override
	public void assignEmployees() {
	    int appointmentLength = appointmentIds.length;
	    int employeeLength = eid.length;
	    int i = 0;
	    
	    displayAppointments();
	    displayEmployees();
	    
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the Appointment Number : ");
	    int appointmentNumber = sc.nextInt();
	    
	    while (i < appointmentLength) {
	        int j = 0;
	        
	        if (appointmentNumber == appointmentIds[i]) {
	            int attempts = 3; // Number of attempts allowed
	            while (attempts > 0) {
	                System.out.println("Enter the Employee ID (Attempts left: " + attempts + "):");
	                int employeeId = sc.nextInt();
	                
	                while (j < employeeLength) {
	                    if (employeeId == eid[j]) {
	                        System.out.println(employeeName[j] + " is assigned to appointment number" + appointmentNumber);
	                        return; // Successful assignment, exit the method
	                    }
	                    j++;
	                }
	                
	                System.out.println("Employee not found. Please Try Again.");
	                attempts--;
	                j = 0; // Resetting the index for employee array for the next attempt
	            }
	            // If attempts are exhausted and employee is still not found
	            System.out.println("Maximum attempts reached. Assignment canceled.");
	            return;
	        }
	        i++;
	    }
	    // If appointment is not found
	    System.out.println("Appointment not found.");
	}
}
