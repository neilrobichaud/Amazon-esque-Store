
import java.io.*;
import java.lang.reflect.Array;
import java.util.*; 


public class UserInterface {	//userinterface class
	

	//public static ArrayList<Item> audioProducts;										//arraylist that will hold the audioproduct objects
	//public ArrayList<Item> readables;											//arraylist that will hold the readables objects
	public ArrayList<ArrayList<String>> arrayR;									//2d arraylist holding info on  readables
	public ArrayList<ArrayList<String>> arrayA;									//2d arraylist holding info on audio products
	public void getArrayR() throws FileNotFoundException{						//creates the 2d arraylist holding readable info
		arrayR = read4SaleTxt("Books.txt","Book","Ebooks.txt","eBook");			//calls the function to do so
	}
	public void getArrayA() throws FileNotFoundException{						//creates the 2d arraylist holding audio info
		arrayA = read4SaleTxt("MP3.txt","MP3","CDs.txt","CD");					//calls the function to do so
	}
	public void showReadables(){
		System.out.printf("%-4.4s %-25.25s %-8.8s %-10.10s %-20.20s %-5.5s\n","S.No","Name of the Book","Author","Price($)","Quantity in Store","Type");//prints with appropriate spacing
		for(int i=0;i<arrayR.size();i++){																												//prints all the info on all the books
			System.out.printf("%-4.4s %-25.25s %-8.8s %-10.10s %-20.20s %-5.5s\n",arrayR.get(i).get(0),arrayR.get(i).get(1),arrayR.get(i).get(2),arrayR.get(i).get(3),arrayR.get(i).get(4).trim(),arrayR.get(i).get(5));
		}
	}
	public void showAudioProducts(){
		System.out.printf("%-4.4s %-25.25s %-8.8s %-10.10s %-20.20s %-5.5s\n","S.No","Name","Artist","Price($)","Quantity in Store","Type");//prints with appropriate spacing
		for(int i=0;i<arrayA.size();i++){																									//prints all the info on all the audioproducts
			System.out.printf("%-4.4s %-25.25s %-8.8s %-10.10s %-20.20s %-5.5s\n",arrayA.get(i).get(0),arrayA.get(i).get(1),arrayA.get(i).get(2),arrayA.get(i).get(3),arrayA.get(i).get(4).trim(),arrayA.get(i).get(5));
		}
	}
	public ArrayList<Item> getAudioProducts() throws FileNotFoundException{
		ArrayList<Item> audioProducts = new ArrayList<Item>();
		getArrayA();
		for(int i=0;i<arrayA.size();i++){																											//goes through the amount of audio products there are
			if(arrayA.get(i).get(5).equals("MP3")){																									//ensures that it grabs the mp3s
				MP3 a = new MP3(arrayA.get(i).get(0),arrayA.get(i).get(1),arrayA.get(i).get(3),arrayA.get(i).get(2),arrayA.get(i).get(5));			//creates a new mp3 object
				audioProducts.add(a);																												//adds the object to the arraylist
			}
			else{
				CD b = new CD(arrayA.get(i).get(0),arrayA.get(i).get(1),arrayA.get(i).get(3),arrayA.get(i).get(2),arrayA.get(i).get(5));			//creates the cd objects
				audioProducts.add(b);																												//adds cds to the audioproducts arraylist
			}
		}
		return audioProducts;
	}
	public ArrayList<Item> getReadables() throws FileNotFoundException{
		ArrayList<Item> readables = new ArrayList<Item>();
		getArrayR();
		for(int i=0;i<arrayR.size();i++){																											//goes through the amount of readable products there are
			if(arrayR.get(i).get(5).equals("Book")){																								//ensures to grab the physical books
				Book c = new Book(arrayR.get(i).get(0),arrayR.get(i).get(1),arrayR.get(i).get(3),arrayR.get(i).get(2),arrayR.get(i).get(5));		//creates the book object
				readables.add(c);																													//adds the book objects to the arraylist
			}
			else{
				eBook d = new eBook(arrayR.get(i).get(0),arrayR.get(i).get(1),arrayR.get(i).get(3),arrayR.get(i).get(2),arrayR.get(i).get(5));		//creates the eBook objects		
				readables.add(d);																													//adds the eBook objects to the readables arraylist
			}
		}
		return readables;
	}
	public  int currentPage; // the page number (p1..p10)
	public int getCurrentPage() {//This method is for page navigation. Based on the values of the state variable, returns different pages
		return currentPage;
	}
	public  int changeCurrentPage(int nextPage) throws FileNotFoundException, IOException{//This method is for page navigation. It should change to current page and show the content.
		if (nextPage == 1){currentPage=nextPage;page1();}	//if x go to page x
		if (nextPage == 2){currentPage=nextPage;page2();}	//if x go to page x
		if (nextPage == 3){currentPage=nextPage;page3();}	//if x go to page x
		if (nextPage == 4){currentPage=nextPage;page4();}	//if x go to page x
		if (nextPage == 5){currentPage=nextPage;page5();}	//if x go to page x
		if (nextPage == 6){currentPage=nextPage;page6();}	//if x go to page x
		if (nextPage == 7){currentPage=nextPage;page7();}	//if x go to page x
		if (nextPage == 8){currentPage=nextPage;page8();}	//if x go to page x
		if (nextPage == 9){currentPage=nextPage;page9();}	//if x go to page x
		if (nextPage == 10){currentPage=nextPage;page10();}
		return nextPage;
	}
	public   void page1() throws FileNotFoundException, IOException{	
		Scanner a = new Scanner(System.in);								//takes input for the first page and goes to sign in or sign up
		String p1choice;
		System.out.println("1.Sign in");								//prints to screen
		System.out.println("2.Sign up");								//prints
		System.out.print("Choose your option:");						//you get the idea
		p1choice = a.next();											//next input
		if(p1choice.equals("1")){										//if its one
			changeCurrentPage(3);										//option 1 goes to page 3
		}
		else if(p1choice.equals("2")){									//if 2
			changeCurrentPage(2);										//option 2 goes to page 2
		}
		else{
			System.out.println("Please enter a valid input");			//if incorrect input is entered relay this message and repeat page1
			changeCurrentPage(1);										//go back to stage 1
		}
		a.close();
	}
	
	public  void page2() throws FileNotFoundException, IOException{		//page2
		System.out.print("Choose your username:");					//prints to screen
		File file = new File("Users.txt");							//get file
		Scanner a = new Scanner(System.in);							//take input
		String p2choice = a.next();
		FileWriter write;											//make a filewriter
		if(isInFile(p2choice, "Users.txt")){						//check if the username is already made
			System.out.println("That username already exists");		//print to screen
			changeCurrentPage(1);									//to page 1
		}
		else{														//if not just create new user
			try {
				write = new FileWriter(file, true);					//append to end of file
				BufferedWriter buffer = new BufferedWriter(write);	//buffered writer to not erase
				if (file.length() != 0){
					buffer.newLine();								//if names then put in next line
					buffer.write(p2choice);
				}else{
					buffer.write(p2choice);							//if no names then put in first spot
				}
				buffer.close();										//close buffered writer
				System.out.println("Username successfully added");	//print to screen
				PrintWriter writer = new PrintWriter(p2choice+"_cart.txt", "UTF-8");							//get file
				writer.close();
				changeCurrentPage(1);								//to page 1
				}
			catch (IOException e) {		//catch statement
			e.printStackTrace();		//pritn stack
			}
		}
		a.close();
	}
	public  void page3() throws FileNotFoundException, IOException {								//page 3

		Scanner a = new Scanner(System.in);				//create input scanner
		String p3choice;								//string
		System.out.print("Enter your username:");		//prints to screen
		p3choice = a.next();							//take next input
		if(isInFile(p3choice, "Users.txt")){			//check if the username is in the file
			String cartname1= p3choice + "_cart.txt";	//make cartname
			File file = new File(cartname1);			//new file
			if (file.exists() == false){				//check if the file exists
				PrintWriter writer = new PrintWriter(cartname1, "UTF-8");		//if not then make it
				writer.close();							//close the writer
			}
			System.out.println("Hello " + p3choice);	//prints to screen			
			User myuser= new User();					//make new user
			myuser.setUsername(p3choice);				//setusername call
			changeCurrentPage(5);						//to page 5
		}
		else{											//if not in file
			changeCurrentPage(4);						//to page 4
		}
		a.close();
	}
	public  void page4() throws FileNotFoundException, IOException{						//page 4 pretty self explanitory
		System.out.println("No Access");												//prints to screen
		changeCurrentPage(1);							//to page 1
	}
	public   boolean isInFile(String input, String infile){	//Useful for checking if a string is in a file
		File file = new File(infile);						//takes input file
		Scanner reader = null;								//creates a new scanner to read a file
		try {
			reader = new Scanner(file);						//tries to read the file
		} catch (FileNotFoundException e) {					//catch
			e.printStackTrace();							//print stack
		}
		List<String> list=new ArrayList<>();				//creates an arraylist
		while(reader.hasNextLine()){						//while there is text
			list.add(reader.nextLine());					//add the content to the arraylist
		}
		reader.close();										//memory leack
		return list.contains(input);						//check if the input is actually in the file and return boolean
	}

	public  void page5() throws FileNotFoundException, IOException{		//central menu

		System.out.println("\n"+"\n");								//for spacing of pages
		System.out.println("1.View items by category");				//options

		System.out.println("2.View shopping cart");					//option 1
		System.out.println("3.Sign out");							//optioon 2
		System.out.println("4.Checkout");				//otpiotn 3
		System.out.print("Choose your option:");					//choose one		
		Scanner x = new Scanner(System.in);							//scanner taking input
		String p5choice = x.next();									
		if (p5choice.equals("1"))
			changeCurrentPage(6);									//first option brings to page 6
		else if (p5choice.equals("2")) 								//if 2
			changeCurrentPage(7);									//second brings to page 7
		else if (p5choice.equals("3")){								//if 3
			System.out.println();									//signs out and brings to page 3
			changeCurrentPage(1);}									//swtich page1
		else if (p5choice.equals("4"))								//if 4
			changeCurrentPage(10);									//MAYBE BRINGS TO PAGE 11, never happened because we didn't finish the bonus
		else System.out.println("Please enter a valid input");{		//if invalid input is entered 
			changeCurrentPage(5);
		}
		x.close();
	}
	public  void page6() throws FileNotFoundException, IOException{		//page 6 function woot

		System.out.println("\n"+"\n");								//spacing for format
		System.out.println("1. Readables");							//prints options to screen


		System.out.println("2. Audio");
		System.out.println("Choose your option");
		System.out.println("Press -1 to return to previous menu");
		
		Scanner x = new Scanner(System.in);							//scanner taking input
		String p6choice = x.next();		
					
		if (p6choice.equals("1"))
			changeCurrentPage(8);									//option 1 brings to page 8
		else if (p6choice.equals("2"))
			changeCurrentPage(9); 									//option 2 brings to page 9
		else if (p6choice.equals("-1"))
			changeCurrentPage(5);									//pressing -1 brings back to previous page
		else {
			System.out.println("Please enter a valid input");
			changeCurrentPage(6);}									//if invalid input is pressed return to page 6
		x.close();
	}
	public  void page7() throws FileNotFoundException, IOException{		//throws ioexception etc
		ArrayList<String> content = ShoppingCart.getContent();			//stores the content of the shopping cart
		if (content.size() > 0){										//if there is stuff in the cart
			for(int i = 0; i < content.size(); i++) {   				//loop through it
			    System.out.println(content.get(i));						//print it
			} 
		}
		else{																							//otherwise
			System.out.println("There appears to be nothing here, maybe you should buy something!");	//print
			changeCurrentPage(5);																		//switch to page5 menu
		}
		System.out.println("Press any key to return to previous menu");								//prompt
		Scanner x = new Scanner(System.in);			//scanner
		String p7choice = x.next();			//take next input
		if (p7choice.equals("-1"))			//if its -1 
			changeCurrentPage(5);			//return to central menu
		else {
			changeCurrentPage(5);			//like you ever had a choice...
			
		}
		x.close();						//closes memory leak
	}
	public  ArrayList<ArrayList<String>> read4SaleTxt(String txtFile,String type,String txtFile2,String type2) throws FileNotFoundException{ //function to read for sale texts
		String token = "";															//creates empty string
		Scanner inFile = new Scanner(new File(txtFile)).useDelimiter(", |\n");		//new scanner that stops every time it reaches ", " or a new line character
		ArrayList<ArrayList<String>> contentsf = new ArrayList<ArrayList<String>>();//2d array list to store all contents
		while(inFile.hasNext()){													//while loop going through the intended file
			ArrayList<String> contents = new ArrayList<String>();					//create 1d arraylist to store the info strings in
			for(int i=0;i<5;i++){													//only 5 strings needed so go through exactly 5 times
				token = inFile.next();												//grabs strings in order
				contents.add(token.trim());												//add each string the 1d arraylist
			}
			contents.add(type);
			contentsf.add(contents);												//add the 1d arraylists to the 2d arraylist to use all of them after
		}
		inFile.close();																//close file
		Scanner inFile2 = new Scanner(new File(txtFile2)).useDelimiter(", |\n");
		while(inFile2.hasNext()){													//while loop going through the intended file
			ArrayList<String> contents = new ArrayList<String>();					//create 1d arraylist to store the info strings in
			for(int i=0;i<5;i++){													//only 5 strings needed so go through exactly 5 times
				token = inFile2.next();												//grabs strings in order

				contents.add(token.trim());											//add each string the 1d arraylist

			}
			contents.add(type2);
			contentsf.add(contents);												//add the 1d arraylists to the 2d arraylist to use all of them after
		}
		inFile2.close();
		return contentsf;															//return all info
	}

	public  void page8() throws IOException{																//page 8
		System.out.println("Choose your option:");															//prints to screen
		System.out.println("Press 0 to checkout, or -1 to return to the previous menu"+"\n");
		showReadables();																					//prints the readables to screen for viewing
		Scanner a = new Scanner(System.in);																	//scanner for input
		ArrayList<String> serialNoList= new ArrayList<String>();											//creates an arraylist for the serial numbers
		for(int i=0;i<arrayR.size();i++){																	//for loop to enter all the serial numbers into the arraylist^^
			serialNoList.add(arrayR.get(i).get(0));
		}
		String p8choice1 = a.next();
		if(p8choice1.equals("0")){changeCurrentPage(10);}													//if entering 0 then checkout at page 10
		else if(p8choice1.equals("-1")){changeCurrentPage(6);}												//-1 brings the user back to previous page
		else if(serialNoList.contains(p8choice1)){															//checks if what the user entered is a valid serial number
			System.out.println("How many?: ");																//asks this on the screen

			String p8choice2 = a.next();
			try{
				Integer.parseInt(p8choice2);																//checks if it is actually a proper entry
			}
			catch(NumberFormatException exception){
				System.out.println("Please re-select your choice and enter a valid quantity: " + "\n");		//prints to screen
				changeCurrentPage(8);																		//repeats page
			}
			String txtFile;																					//creates a string variable to hold the name of whichever textfile we are accessing
			if(arrayR.get(serialNoList.indexOf(p8choice1)).get(5).equals("Book")){txtFile = "Books.txt";}
			else{txtFile = "Ebooks.txt";}																	//assigns the proper String name depending on what kind of file it is
			try (BufferedReader br = new BufferedReader(new FileReader(txtFile))) {							//creates a buffered reader to read the file
			    String line;
			    String updatedline="";
			    Boolean found=false;
			    
			    while ((line = br.readLine()) != null) {
			    	String[] parts = line.split(", ");							//splits line into a list at comma
			    	if (parts[0].equals(p8choice1)){				//if the first value in the list is equal to the serial number			    		
			    		if (Integer.parseInt(parts[4]) >= Integer.parseInt(p8choice2)&&Integer.parseInt(p8choice2)>0){
				    		parts[4]=Integer.toString(Integer.parseInt(parts[4]) - Integer.parseInt(p8choice2));		//the quantity string is updated
				    		arrayR.get(serialNoList.indexOf(p8choice1)).set(4,Integer.toString(Integer.parseInt(arrayR.get(serialNoList.indexOf(p8choice1)).get(4))-Integer.parseInt(p8choice2)));	//call get array
				    		ShoppingCart.addItem(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(p8choice2)); //add item to cart
				    		for (int i=0;i<parts.length-1;i++){										//loops through parts except for last part
				    			updatedline= updatedline + parts[i] + ", " ;							//concatenates each string to updatedline
				    		}
				    		updatedline=updatedline+parts[parts.length-1];							//concatenates the final value, done this way to ensure proper comma placement
				    		
				    		try {
					    		BufferedReader file = new BufferedReader(new FileReader(txtFile));		//read cart
					            String line1;String input = "";											//create two string variables
					            while ((line1 = file.readLine()) != null) input += line1 + '\n';		//read contents of cart into input
					            file.close();															//close cart
					            input=input.replace(line, updatedline);									//update input
					            FileOutputStream fileOut = new FileOutputStream(txtFile);				//overwrite cart
					            fileOut.write(input.getBytes());										//write input
					            fileOut.close();														//close new cart file
					    	    } catch (Exception e) {													//catch
					    	        System.out.println("Problem reading file.");						//print error message
					    	    }
				            found=true;																	//sets found to true. no real point
				            break;																		//break
			    		}
			    		else{			    			

			    			System.out.println("There are "+ parts[4] + " items left please choose your option again with a smaller quantity."+"\n"); //if you pick up too many
			    			changeCurrentPage(8);																				//reset the page
			    		}
			    	}
			    }
		}
	}
		
		else{
			System.out.println("Please choose a valid option");												//prints to screen
			changeCurrentPage(8);																			//repeats page 8
		}
	System.out.println("Item Successfully added to your Cart!");																			//prints success to the screen
	changeCurrentPage(8);																					//repeats page to see if user wants to shop some more
	}
	

	public  void page9() throws IOException{																//page9		
		System.out.println("Choose your option:");															//prints to screen
		System.out.println("Press 0 to checkout");															//print to screen
		System.out.println("Press -1 to return to the previous menu");										//print to screen
		showAudioProducts();																				//prints the audioproducts to screen for viewing
		Scanner a = new Scanner(System.in);																	//scanner for input
		ArrayList<String> serialNoList= new ArrayList<String>();											//creates an arraylist for the serial numbers
		for(int i=0;i<arrayA.size();i++){																	//for loop to enter all the serial numbers into the arraylist^^
			serialNoList.add(arrayA.get(i).get(0));															//populate list with serial numbers
		}
		String p9choice1 = a.next();
		if(p9choice1.equals("0")){changeCurrentPage(10);}													//if entering 0 then checkout at page 10
		else if(p9choice1.equals("-1")){changeCurrentPage(6);}												//-1 brings the user back to previous page
		else if(serialNoList.contains(p9choice1)){															//checks if what the user entered is a valid serial number
			System.out.println("How many?: ");																//asks this on the screen
			String p9choice2 = a.next();																	//next input
			try{
				Integer.parseInt(p9choice2);																//checks if it is actually a proper entry
			}
			catch(NumberFormatException exception){
				System.out.println("Please re-select your choice and enter a valid quantity: " + "\n");		//prints to screen
				changeCurrentPage(9);																		//repeates page

			}
			String txtFile;																					//creates a string variable to hold the name of whichever textfile we are accessing
			if(arrayA.get(serialNoList.indexOf(p9choice1)).get(5).equals("MP3")){txtFile = "MP3.txt";}		//assigns the proper textfile to the variable depending on what the user buys
			else{txtFile = "CDs.txt";}
			try (BufferedReader br = new BufferedReader(new FileReader(txtFile))) {							//creates a buffered reader
			    String line;																				//string line
			    String updatedline="";																		//empty updated line
			    Boolean found=false;																		//pointless bool for fun
			    
			    while ((line = br.readLine()) != null) {
			    	String[] parts = line.split(", ");							//splits line into a list at comma
			    	if (parts[0].equals(p9choice1)){				//if the first value in the list is equal to the serial number			    		
			    		if (Integer.parseInt(parts[4]) >= Integer.parseInt(p9choice2)&&Integer.parseInt(p9choice2)>0){	//if the choice is bigger than 0 but below the limit
				    		parts[4]=Integer.toString(Integer.parseInt(parts[4]) - Integer.parseInt(p9choice2));		//the quantity string is updated
				    		ShoppingCart.addItem(Integer.parseInt(parts[0]),parts[1],Integer.parseInt(p9choice2));		//add this item to the cart
				    		arrayA.get(serialNoList.indexOf(p9choice1)).set(4,Integer.toString(Integer.parseInt(arrayA.get(serialNoList.indexOf(p9choice1)).get(4))-Integer.parseInt(p9choice2))); //call array.get
				    		for (int i=0;i<parts.length-1;i++){										//loops through parts except for last part
				    			updatedline= updatedline + parts[i] + ", " ;							//concatenates each string to updatedline
				    		}
				    		updatedline=updatedline+parts[parts.length-1];							//concatenates the final value, done this way to ensure proper comma placement
				    		
				    		try {
					    		BufferedReader file = new BufferedReader(new FileReader(txtFile));		//read cart
					            String line1;String input = "";											//create two string variables
					            while ((line1 = file.readLine()) != null) input += line1 + '\n';		//read contents of cart into input
					            file.close();															//close cart
					            input=input.replace(line, updatedline);									//update input
					            FileOutputStream fileOut = new FileOutputStream(txtFile);				//overwrite cart
					            fileOut.write(input.getBytes());										//write input
					            fileOut.close();														//close new cart file
					    	    } catch (Exception e) {
					    	        System.out.println("Problem reading file.");
					    	    }
				            found=true;																//uselss bool
				            break;																	//break while loop
			    		}
			    		else{			    			
			    			System.out.println("There are "+ parts[4] + " items left please choose a proper quantity."+"\n");	//error msg
			    			changeCurrentPage(9);																				//reload page
			    		}
			    	}
			    }
			}
		}		
		else{
			System.out.println("Please choose a valid option");												//prints to screen
			changeCurrentPage(9);																			//repeates page 9
		}
	System.out.println("Success!");																			//prints the user was successful in adding to cart
	changeCurrentPage(9);																					//repeats page to see if the user wants to purchase anything
	}
	
	public void page10() throws FileNotFoundException, IOException{
		ArrayList<String> content = ShoppingCart.getContent();
		System.out.println("Billing Information:");
		System.out.printf("%-35.35s %-15.15s %-6.6s", "Name", "Quantity", "Price");
		System.out.println("");
		int totalprice = 0;
		if (content.size() > 0){
			for(int i = 0; i < content.size(); i++) {   
			    String line = content.get(i);
			    String[] parts = line.split(", ");
			    String itemname = parts[1];
			    String quantity = parts[3];
			    String serialNo = parts[0];
			    String price = "";
			   
			    for(int j = 0;j<HWK4_robichne.audioProducts.size();j++){
			    	if(HWK4_robichne.audioProducts.get(j).getSno()==Integer.parseInt(serialNo)){
			    		price = Integer.toString(HWK4_robichne.audioProducts.get(j).getPrice());
			    		System.out.printf("%-35.35s %-15.15s %-6.6s",itemname,quantity,price);
			    		System.out.println("");
			    	}
			    }
			    for(int k = 0;k<HWK4_robichne.readables.size();k++){
			    	if(HWK4_robichne.readables.get(k).getSno()==Integer.parseInt(serialNo)){
			    		price = Integer.toString(HWK4_robichne.readables.get(k).getPrice());
			    		System.out.printf("%-35.35s %-15.15s %-6.6s",itemname,quantity,price);
			    		System.out.println("");
			    	}
			    }
			    totalprice = totalprice + Integer.parseInt(quantity)*Integer.parseInt(price);
			}
			System.out.printf("%-45.45s %-11.11s", "" , "___________");
			System.out.printf("%-50.50s %-6.6s","Total:", totalprice);
			Scanner a = new Scanner(System.in);
			String p10choice = a.next();
			System.out.println("Are you sure you want to pay? yes or no.");
			if(p10choice.equalsIgnoreCase("Yes")){
				System.out.println("Confirmation ID: U1000");
				System.out.println("Items shipped to: " + ShoppingCart.getUsername());
			}
			else if(p10choice.equalsIgnoreCase("No")){
				changeCurrentPage(6);
			}
			else{System.out.println("Please enter a valid input");changeCurrentPage(10);}
		}
	}



		
}	

		
	
	

