package osgi_servicepublisher;

import java.util.Scanner;



public class ServicePublishImpl implements ServicePublish {

	
	
	
	/*String[] m_dictionary = {"welcome","to","osgi","tutorial"};

	@Override
	public boolean checkWord(String word) {
		word = word.toLowerCase();
		for(int i = 0; i< m_dictionary.length; i++) {
			if(m_dictionary[i].equals(word)) {
				return true;
			}
		
		}
		return false;
	}*/
	
	QueueX powder = new QueueX(80);
	QueueX shampoo = new QueueX(80);
	QueueX hairOil = new QueueX(50);
	QueueX shawingCream = new QueueX(100);
	
	QueueX trimmers = new QueueX(30);
	QueueX siccors = new QueueX(50);
	QueueX  blades= new QueueX(1000);
	QueueX razors= new QueueX(100);
	QueueX sponges= new QueueX(80);
	
	@Override
	public void cosmeticCount() {
		System.out.println("Do you want to take what Count of Cosmetic");
		System.out.println("Press Relavent letters to take");
		System.out.println("1 - Powder");
		System.out.println("2 - Shampoo");
		System.out.println("3 - Hair Oil");
		System.out.println("4 - Shawing Cream");
		
		Scanner sc = new Scanner(System.in);
		int letter = sc.nextInt();
		
		if(letter == 1) {
			
			System.out.println("Required amount of Powder bottles are in the Store.");

		}else if(letter == 2) {
			
			System.out.println("Required amount of Shampoo bottles are in the Store");		
		}else if(letter == 3) {
			
			System.out.println("Press Relavent letters to take");
			
		}else if(letter == 4) {
			
			System.out.println("Press Relavent letters to take");

			
		}else {
			System.out.println("Press Relavent letters to take");
		}
	
		
	}

	@Override
	public void addCosmeticts() {
		System.out.println("Do you want to ADD what kind of Cosmetic");
		System.out.println("Press Relavent letters to take");
		System.out.println("1 - Powder");
		System.out.println("2 - Shampoo");
		System.out.println("3 - Hair Oil");
		System.out.println("4 - Shawing Cream");
		
		Scanner sc = new Scanner(System.in);
		int letter = sc.nextInt();
		
		if(letter == 1) {
			while(true) {
			System.out.println("Please enter the Item Id to Add Cosmetic Item");
			System.out.println("Please enter 0 to stop adding Item to Queue");

			Scanner sc1 = new Scanner(System.in);
			int id = sc1.nextInt();
			if(id == 0 ) 
			{
				System.out.println("Are you want to take anonther Item");
				Scanner sc4 = new Scanner(System.in);
				String letter1 = sc4.next();
				if(letter1.toLowerCase().equals("y") ){
					addCosmeticts();
					
				}else if(letter1.toLowerCase().equals("n")) {
					
					System.out.println("Do not forget to more service");
					break;
					
				}else {
					System.out.println("Invalid Input");
					break;
					
				}
				
			}else {
			powder.insert(id);
			System.out.println("Powder has added");
			}
			}

		}else if(letter == 2) {
			System.out.println("Please enter the Item Id");
			Scanner sc1 = new Scanner(System.in);
			int id = sc1.nextInt();
			shampoo.insert(id);
			System.out.println("Shampoo Has added");
			
		}else if(letter == 3) {
			System.out.println("Please enter the Item Id");
			Scanner sc1 = new Scanner(System.in);
			int id = sc1.nextInt();
			hairOil.insert(id);
			
			System.out.println("Hair Oil has added");

			
		}else if(letter == 4) {
			System.out.println("Please enter the Item Id");
			Scanner sc1 = new Scanner(System.in);
			int id = sc1.nextInt();
			shawingCream.insert(id);
			
			System.out.println("Shawing Cream has added");

			
		}else {
			System.out.println("Invalid Input by the Sallon Admin Please Follow the Instructions Properly");

		}
		
	}
	
	@Override
	public void equipmentCount() {
		System.out.println("Do you want to take what kind of Equipment Count ");
		System.out.println("Press Relavent letters to take");
		System.out.println("1 - trimmers");
		System.out.println("2 - siccors");
		System.out.println("3 - blades");
		System.out.println("4 - razors");
		System.out.println("5 - sponges");
		
		Scanner sc = new Scanner(System.in);
		int letter = sc.nextInt();
		
		if(letter == 1) {
			System.out.println("Required Amount of Trimmers are in the Store.");

		}else if(letter == 2) {
			
			System.out.println("Required Amount of Siccors are in the Store.");
			
		}else if(letter == 3) {
			
			System.out.println("Required Amount of Blades are in the Store");
			
			
		}else if(letter == 4) {
			
			System.out.println("Press Relavent letters to take");

			
		}
         else if(letter == 5) {
			
        	 System.out.println("Press Relavent letters to take");
			
		}else {
			
			System.out.println("Press Relavent letters to take");

		}
		
	}

	@Override
	public void addEquipment() {
		System.out.println("Do you want to ADD what kind of Equipment");
		System.out.println("Press Relavent letters to take");
		System.out.println("1 - trimmers");
		System.out.println("2 - siccors");
		System.out.println("3 - blades");
		System.out.println("4 - razors");
		System.out.println("5 - sponges");
		
		Scanner sc = new Scanner(System.in);
		int letter = sc.nextInt();
		
		if(letter == 1) {
			while(true) {
			System.out.println("Please enter the Item Id to Add Equipment Item");
			System.out.println("Please enter 0 to stop adding Item to Queue");
			Scanner sc1 = new Scanner(System.in);
			int id = sc1.nextInt();
			if(id == 0 ) 
			{
				System.out.println("Are you want to take anonther Item");
				Scanner sc6 = new Scanner(System.in);
				String letter1 = sc6.next();
				if(letter1.toLowerCase().equals("y") ){
					addEquipment();
					
				}else if(letter1.toLowerCase().equals("n")) {
					
					System.out.println("Do not forget to more service");
					break;
					
				}else {
					System.out.println("Invalid Input");
					break;
					
				}
				
			}else {
			trimmers.insert(id);
			System.out.println("Trimmers has added");
			}
			}

		}else if(letter == 2) {
			System.out.println("Please enter the Item Id");
			Scanner sc1 = new Scanner(System.in);
			int id = sc1.nextInt();
			siccors.insert(id);
			System.out.println("Siccors Has added");
			
		}else if(letter == 3) {
			System.out.println("Please enter the Item Id");
			Scanner sc1 = new Scanner(System.in);
			int id = sc1.nextInt();
			blades.insert(id);
			System.out.println("Blades has added");

			
		}else if(letter == 4) {
			System.out.println("Please enter the Item Id");
			Scanner sc1 = new Scanner(System.in);
			int id = sc1.nextInt();
			razors.insert(id);
			System.out.println("Razors has added");

			
		}
         else if(letter == 5) {
        	 System.out.println("Please enter the Item Id");
 			Scanner sc1 = new Scanner(System.in);
 			int id = sc1.nextInt();
			sponges.insert(id);
			System.out.println("Sponges has added");

			
		}else {
			System.out.println("Invalid Input by the Sallon Admin Please Follow the Instructions Properly");

		}
		

		
	}
	
	
	
	@Override
	public void equipmentAvailability() {
		
		System.out.println("Do you want to take what kind of Equipment");
		System.out.println("Press Relavent letters to take");
		System.out.println("1 - trimmers");
		System.out.println("2 - siccors");
		System.out.println("3 - blades");
		System.out.println("4 - razors");
		System.out.println("5 - sponges");
		
		Scanner sc = new Scanner(System.in);
		int letter = sc.nextInt();
		
		if(letter == 1) {
			//trimmers.remove();
			System.out.println("Trimmers has taken");
			System.out.println("Are you want to take anonther Item");
			Scanner sc1 = new Scanner(System.in);
			String letter1 = sc1.next();
			if(letter1.toLowerCase().equals("y") ){
				equipmentAvailability();
				
			}else if(letter1.toLowerCase().equals("n")) {
				
				System.out.println("Do not forget to more service");
				
			}else {
				System.out.println("Invalid Input");
				
			}

		}else if(letter == 2) {
			
			siccors.remove();
			System.out.println("Siccors Has taken");
			
		}else if(letter == 3) {
			
			blades.remove();
			System.out.println("Blades has taken");

			
		}else if(letter == 4) {
			
			razors.remove();
			System.out.println("Razors has taken");

			
		}
         else if(letter == 5) {
			
			sponges.remove();
			System.out.println("Sponges has taken");

			
		}else {
			System.out.println("Invalid Input by the Sallon Hair Maker Please Follow the Instructions Properly");

		}
		
		
	}
	
	
	@Override
	public void cosmeticAvailability() {
		// TODO Auto-generated method stub
		
		System.out.println("Do you want to take what kind of Cosmetic");
		System.out.println("Press Relavent letters to talke");
		System.out.println("1 - Powder");
		System.out.println("2 - Shampoo");
		System.out.println("3 - Hair Oil");
		System.out.println("4 - Shawing Cream");
		
		Scanner sc = new Scanner(System.in);
		int letter = sc.nextInt();
		
		if(letter == 1) {
			//powder.remove();
			System.out.println("Powder has taken");
			System.out.println("Are you want to take anonther Item");
			Scanner sc5 = new Scanner(System.in);
			String letter1 = sc5.next();
			if(letter1.toLowerCase().equals("y") ){
				cosmeticAvailability();
				
			}else if(letter1.toLowerCase().equals("n")) {
				
				System.out.println("Do not forget to more service");
				
			}else {
				System.out.println("Invalid Input");
				
			}

		}else if(letter == 2) {
			
			shampoo.remove();
			System.out.println("Shampoo Has taken");
			
		}else if(letter == 3) {
			
			hairOil.remove();
			System.out.println("Hair Oil has taken");

			
		}else if(letter == 4) {
			
			shawingCream.remove();
			System.out.println("Shawing Cream has taken");

			
		}else {
			System.out.println("Invalid Input by the Sallon Hair Maker Please Follow the Instructions Properly");

		}
		

	}


	
	

}
