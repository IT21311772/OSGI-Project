package osgi_servicesubscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;


import osgi_servicepublisher.ServicePublish;

public class ServiceActivator implements BundleActivator {

	ServiceReference serviceReference;
	
	

	public void start(BundleContext context) throws Exception {
		System.out.println("Starts subscriber survice");
		
		
		try {
		
		serviceReference = context.getServiceReference(ServicePublish.class.getName());
		ServicePublish servicePublish = (ServicePublish)context.getService(serviceReference);
			
			
			/*while(true) {
				
				
				System.out.println("Enter Word :  ");
				String word = sc.next();
				
				
				if(word.length() == 0 ) 
				{
					break;
					
				}
				else if (servicePublish == null ) 
				{
					System.out.println(" No dictionary Available ");
				}else if (servicePublish.checkWord(word)) {
					System.out.println("Correct");
				} 
				else  
				{
					System.out.println("orrect");
				}
				
				
			}*/
			
			System.out.println("Please Enter Your Username : ");
			Scanner sc1 = new Scanner(System.in);
			String word1 = sc1.next();
			System.out.println("Please Enter Your Password : ");
			Scanner sc2 = new Scanner(System.in);
			String word2 = sc2.next();
			
			if(word1.toLowerCase().equals("admin") && word2.equals("admin1"))
			
			{
			System.out.println("----------------------------------------------------------------");
			System.out.println("Do You want to Add Equipmet OR Add Cosmetics.");
			System.out.println("If you want to Add Equipment Press A");
			System.out.println("If you want to Add Cosmetics Press B");
			System.out.println("----------------------------------------------------------------");
			System.out.println("Do You want to Take Equipmet OR Cosmetics Counts.");
			System.out.println("If you want to Take Present Equipment Count Press C");
			System.out.println("If you want to Take Present Cosmetic Count Press  D");
			Scanner sc = new Scanner(System.in);
			String word = sc.next();
			
		   
		   if(word.toLowerCase().equals ("a")) {
				
				 servicePublish.addEquipment();
					
				}else if (word.toLowerCase().equals ("b") ) {
					
					servicePublish.addCosmeticts();
					
				}
		        else if (word.toLowerCase().equals ("c") ) {
					
					servicePublish.equipmentCount();
					
				}
		        else if (word.toLowerCase().equals ("d") ) {
					
					servicePublish.cosmeticCount();
					
				}
				else {
					System.out.println("Invalid Input by the Saloon Admin Please Follow the System Instructions.");
				}
			
			}else if(word1.toLowerCase().equals("user") && word2.equals("user1"))
			{
				System.out.println("Do You want to take the Cosmetic Items or Saloon Equipments");
				System.out.println("If you want to take Cosmetic Item Press : C :");
				System.out.println("If you want to take Saloon Equipment Press : E :");
				Scanner sc3 = new Scanner(System.in);
				String word = sc3.next();
				
				if(word.toLowerCase().equals ("c")) {
					
					servicePublish.cosmeticAvailability();
					
				}else if (word.toLowerCase().equals ("e") ) {
					
				servicePublish.equipmentAvailability();
					
				}else {
					System.out.println("Invalid Input by the Saloon Hair Maker Please Follow the System Instructions.");
				}
				
				
			}else {
				System.out.println("Please Follow the system Rules");
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		
		
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye");
		context.ungetService(serviceReference);
	}

}


