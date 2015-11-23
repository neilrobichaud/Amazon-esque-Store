import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class UserInterface {
	
	public static void main(String args[]) throws FileNotFoundException, IOException{
		
		page1();
		
	}
	public Array readables;
	public Array audioProducts;
	public static int currentPage; // the page number (p1..p10)
	public int getCurrentPage() {//This method is for page navigation. Based on the values of the state variable, call different pages.
		return currentPage;
	}
	public static int changeCurrentPage(int nextPage) throws FileNotFoundException, IOException{//This method is for page navigation. It should change to current page and show the content.
		if (nextPage == 1){currentPage=nextPage;page1();}
		if (nextPage == 2){currentPage=nextPage;page2();}
		if (nextPage == 3){currentPage=nextPage;page3();}
		if (nextPage == 4){currentPage=nextPage;page4();}
		if (nextPage == 5){currentPage=nextPage;page5();}
		if (nextPage == 6){currentPage=nextPage;page6();}
		if (nextPage == 7){currentPage=nextPage;page7();}
		if (nextPage == 8){currentPage=nextPage;page8();}
		if (nextPage == 9){currentPage=nextPage;page9();}
//		if (nextPage == 10){currentPage=nextPage;page10();}
		return nextPage;
	}
	public void getReadables(){} // fetches all readables from the files and places them in the readables array
	public void getAudioProducts(){} // fetches all readables from the files and places them in the readables array
	public void showReadables(){} //Displays all audio products for browsing.
	public void showAudioProducts(){} //Displays all audio products for browsing.

	public static  void page1() throws FileNotFoundException, IOException{	
		File users, books, ebooks, mp3, cds; users = new File("Users.txt"); books = new File("Books.txt"); ebooks = new File("Ebooks.txt");mp3 = new File("MP3.txt"); cds = new File("CDs.txt");
		try {
			users.createNewFile(); books.createNewFile(); ebooks.createNewFile(); mp3.createNewFile(); cds.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Scanner a = new Scanner(System.in);
		String p1choice;
		System.out.println("1.Sign in");
		System.out.println("2.Sign up");
		System.out.print("Choose your option:");
		p1choice = a.next();
		if(p1choice.equals("1")){
			changeCurrentPage(3);
		}
		else if(p1choice.equals("2")){
			changeCurrentPage(2);
		}
		else{
			System.out.println("Please enter a valid input");
			changeCurrentPage(1);
		}
		a.close();
	}

	public static void page2() throws FileNotFoundException, IOException{
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
			catch (IOException e) {
			e.printStackTrace();
			}
		}
		a.close();
	}
	public static void page3() throws FileNotFoundException, IOException {								//page 3

		Scanner a = new Scanner(System.in);				//create input scanner
		String p3choice;
		System.out.print("Enter your username:");		//prints to screen
		p3choice = a.next();
		if(isInFile(p3choice, "Users.txt")){			//check if the username is in the file
			System.out.println("Hello " + p3choice);	//prints to screen
			User myUser = new User(p3choice);
			changeCurrentPage(5);						//to page 5
		}
		else{											//if not in file
			changeCurrentPage(4);						//to page 4
		}
		a.close();
	}
	public static void page4() throws FileNotFoundException, IOException{						//page 4 pretty self explanitory
		System.out.println("No Access");
		changeCurrentPage(1);							//to page 1
	}
	public static  boolean isInFile(String input, String infile){//subject to change, useful for checking if a string is in a file
		File file = new File(infile);
		Scanner reader = null;
		try {
			reader = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		List<String> list=new ArrayList<>();
		while(reader.hasNextLine()){
			list.add(reader.nextLine());
		}
		reader.close();
		return list.contains(input);
	}

	public static void page5() throws FileNotFoundException, IOException{
		System.out.println("\n"+ "\n");
		System.out.println("1.View items by category");
		System.out.println("2.View shopping cart");
		System.out.println("3.Sign out");
		System.out.println("4.View previous orders");
		System.out.print("Choose your option:");			
		Scanner x = new Scanner(System.in);			//scanner
		String p5choice = x.next();
		if (p5choice.equals("1"))
			changeCurrentPage(6);
		else if (p5choice.equals("2")) 
			changeCurrentPage(7);
		else if (p5choice.equals("3")){
			System.out.println();
			changeCurrentPage(1);}
		else if (p5choice.equals("4"))
			changeCurrentPage(11);
		else {
			System.out.println("Please enter a valid input");
			changeCurrentPage(5);}
		x.close();
	}
	public static void page6() throws FileNotFoundException, IOException{			
		System.out.println("1. Readables");
		System.out.println("2. Audio");
		System.out.println("Choose your option");
		System.out.println("Press -1 to return to previous menu");
		
		Scanner x = new Scanner(System.in);			//scanner
		String p6choice = x.next();		
					
		if (p6choice.equals("1"))
			changeCurrentPage(8);
		else if (p6choice.equals("2")) 
			changeCurrentPage(9);
		else if (p6choice.equals("-1"))
			changeCurrentPage(5);
		else {
			System.out.println("Please enter a valid input");
			changeCurrentPage(6);}
		x.close();
	}
	public static void page7() throws FileNotFoundException, IOException{
		//TODO print contents of uname1_cart.txt
		ArrayList<String> content = ShoppingCart.getContent();
		if (content.size() > 0){
			for(int i = 0; i < content.size(); i++) {   
			    System.out.println(content.get(i));
			} 
		}
		else
			System.out.println("There appears to be nothing here, maybe you should buy something you cheap fuck!");
		
		System.out.println("Press -1 to return to previous menu");
		Scanner x = new Scanner(System.in);			//scanner
		String p7choice = x.next();	
		
		if (p7choice.equals("-1"))
			changeCurrentPage(5);
		else System.out.println("Please enter a valid input");
		
		x.close();
	}
	public static ArrayList<ArrayList<String>> read4SaleTxt(String txtFile,String type) throws FileNotFoundException{
		String token = "";															//creates empty string
		Scanner inFile = new Scanner(new File(txtFile)).useDelimiter(", |\n");		//new scanner that stops every time it reaches ", " or a new line character
		ArrayList<ArrayList<String>> contentsf = new ArrayList<ArrayList<String>>();//2d array list to store all contents
		while(inFile.hasNext()){													//while loop going through the intended file
			ArrayList<String> contents = new ArrayList<String>();					//create 1d arraylist to store the info strings in
			for(int i=0;i<5;i++){													//only 5 strings needed so go through exactly 5 times
				token = inFile.next();												//grabs strings in order
				contents.add(token);												//add each string the 1d arraylist
			}
			contents.add(type);														//add the type of product it is to the end of the arraylist
//			for(int i=0;i<contents.size();i++){System.out.print(contents.get(i));}
			contentsf.add(contents);												//add the 1d arraylists to the 2d arraylist to use all of them after
		}
		inFile.close();																//close file
		return contentsf;															//return all info
	}
	public static void page8() throws IOException{			//page 8
		ArrayList<String> serialNoList = new ArrayList<String>();
		System.out.println("Choose your option:");			//prints to screen
		System.out.printf("%-4.4s %-25.25s %-8.8s %-10.10s %-20.20s %-5.5s\n","S.No","Name of the Book","Author","Price($)","Quantity in Store","Type");//prints with appropriate spacing
		ArrayList<ArrayList<String>> contentsB = read4SaleTxt("Books.txt","Book");			//creates 2d arraylist to store values and uses the function to store contents of books.txt
		for(int i=0;i<contentsB.size();i++){			//prints all the info on all the books
			serialNoList.add(contentsB.get(i).get(0));
			System.out.printf("%-4.4s %-25.25s %-8.8s %-10.10s %-20.20s %-5.5s\n",contentsB.get(i).get(0),contentsB.get(i).get(1),contentsB.get(i).get(2),contentsB.get(i).get(3),contentsB.get(i).get(4),contentsB.get(i).get(5));
		}
		ArrayList<ArrayList<String>> contentsEB = read4SaleTxt("Ebooks.txt","eBook");		//creates 2d arraylist to store values and function to store contents
		for(int i=0;i<contentsEB.size();i++){			//prints all info on all ebooks
			System.out.printf("%-4.4s %-25.25s %-8.8s %-10.10s %-20.20s %-5.5s\n",contentsEB.get(i).get(0),contentsEB.get(i).get(1),contentsEB.get(i).get(2),contentsEB.get(i).get(3),contentsEB.get(i).get(4),contentsEB.get(i).get(5));
		}
		
		Scanner a = new Scanner(System.in);
		String p8choice1 = a.next();
		
		//open 
		if(p8choice1.equals("0")){changeCurrentPage(10);}
		else if(p8choice1.equals("-1")){changeCurrentPage(6);}
		else if(serialNoList.contains(p8choice1)){
			System.out.println("How many?: "+"\n");
			String p8choice2 = a.next();
			try{
				Integer.parseInt(p8choice2);
			}
			catch(NumberFormatException exception){
				System.out.println("Please re-select your choice and enter a valid quantity: " + "\n");				
				changeCurrentPage(8);
			}
			
			try (BufferedReader br = new BufferedReader(new FileReader("Books.txt"))) {
			    String line;
			    String updatedline="";
			    Boolean found=false;
			    
			    while ((line = br.readLine()) != null) {
			    	String[] parts = line.split(", ");							//splits line into a list at comma
			    	if (parts[0].equals(p8choice1)){				//if the first value in the list is equal to the serial number			    		
			    		if (Integer.parseInt(parts[4]) >= Integer.parseInt(p8choice2)){
				    		parts[4]=Integer.toString(Integer.parseInt(parts[4]) - Integer.parseInt(p8choice2));		//the quantity string is updated
				    		for (int i=0;i<parts.length-1;i++){										//loops through parts except for last part
				    			updatedline= updatedline + parts[i] + ", " ;							//concatenates each string to updatedline
				    		}
				    		updatedline=updatedline+parts[parts.length-1];							//concatenates the final value, done this way to ensure proper comma placement
				    		
				    		try {
					    		BufferedReader file = new BufferedReader(new FileReader("Books.txt"));		//read cart
					            String line1;String input = "";											//create two string variables
					            while ((line1 = file.readLine()) != null) input += line1 + '\n';		//read contents of cart into input
					            file.close();															//close cart
					            input=input.replace(line, updatedline);									//update input
					            FileOutputStream fileOut = new FileOutputStream("Books.txt");				//overwrite cart
					            fileOut.write(input.getBytes());										//write input
					            fileOut.close();														//close new cart file
					    	    } catch (Exception e) {
					    	        System.out.println("Problem reading file.");
					    	    }
				            found=true;
				            break;
			    		}
			    		else{			    			
			    			System.out.println("There are only "+ parts[4] + " items left please choose a lower quantity."+"\n");
			    			changeCurrentPage(8);
			    		}
			    	}		    	
			    }

			//modify books.txt can use code from additem in shoppingcart
		}
	}
		
		else{
			System.out.println("Please choose a valid option");
			changeCurrentPage(8);
		}
	System.out.println("Success!");
	changeCurrentPage(8);
	}
	public static void page9() throws FileNotFoundException{			//page9
		System.out.println("Choose your option:");			//prints to screen
		System.out.printf("%-4.4s %-25.25s %-8.8s %-10.10s %-20.20s %-5.5s\n","S.No","Name","Artist","Price($)","Quantity in Store","Type");//prints with appropriate spacing with printf
		ArrayList<ArrayList<String>> contentsCD = read4SaleTxt("CDs.txt","CD");			//2d arraylist to store values and function to store contents of CDs.txt
		for(int i=0;i<contentsCD.size();i++){			//prints info from cds with appropriate spacing
			System.out.printf("%-4.4s %-25.25s %-8.8s %-10.10s %-20.20s %-5.5s\n",contentsCD.get(i).get(0),contentsCD.get(i).get(1),contentsCD.get(i).get(2),contentsCD.get(i).get(3),contentsCD.get(i).get(4),contentsCD.get(i).get(5));
		}
		ArrayList<ArrayList<String>> contentsMP3 = read4SaleTxt("MP3.txt","MP3");	//2d arraylist to store values and function used to get the contents of MP3.txt
		for(int i=0;i<contentsMP3.size();i++){			//prints info from mp3s with appropriate spacing
			System.out.printf("%-4.4s %-25.25s %-8.8s %-10.10s %-20.20s %-5.5s\n",contentsMP3.get(i).get(0),contentsMP3.get(i).get(1),contentsMP3.get(i).get(2),contentsMP3.get(i).get(3),contentsMP3.get(i).get(4),contentsMP3.get(i).get(5));
		}
	}
	
}	