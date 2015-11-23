import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class UserInterface {
	
//	public static void main(String args[]) throws FileNotFoundException, IOException{
//		getArrayA();
//		getArrayR();
//		page1();
//	}
	
	public ArrayList<Item> audioProducts;
	public ArrayList<Item> readables;
	public ArrayList<ArrayList<String>> arrayR;
	public ArrayList<ArrayList<String>> arrayA;
	public void getArrayR() throws FileNotFoundException{
		arrayR = read4SaleTxt("Books.txt","Book","Ebooks.txt","eBook");
	}
	public void getArrayA() throws FileNotFoundException{
		arrayA = read4SaleTxt("MP3.txt","MP3","CDs.txt","CD");
	}
	public void showReadables(){
		System.out.printf("%-4.4s %-25.25s %-8.8s %-10.10s %-20.20s %-5.5s\n","S.No","Name of the Book","Author","Price($)","Quantity in Store","Type");//prints with appropriate spacing
		for(int i=0;i<arrayR.size();i++){			//prints all the info on all the books
			System.out.printf("%-4.4s %-25.25s %-8.8s %-10.10s %-20.20s %-5.5s\n",arrayR.get(i).get(0),arrayR.get(i).get(1),arrayR.get(i).get(2),arrayR.get(i).get(3),arrayR.get(i).get(4).trim(),arrayR.get(i).get(5));
		}
	}
	public void showAudioProducts(){
		System.out.printf("%-4.4s %-25.25s %-8.8s %-10.10s %-20.20s %-5.5s\n","S.No","Name","Artist","Price($)","Quantity in Store","Type");//prints with appropriate spacing
		for(int i=0;i<arrayA.size();i++){			//prints all the info on all the books
			System.out.printf("%-4.4s %-25.25s %-8.8s %-10.10s %-20.20s %-5.5s\n",arrayA.get(i).get(0),arrayA.get(i).get(1),arrayA.get(i).get(2),arrayA.get(i).get(3),arrayA.get(i).get(4).trim(),arrayA.get(i).get(5));
		}
	}
	public void getAudioProducts() throws FileNotFoundException{
		getArrayA();
		for(int i=0;i<arrayA.size();i++){
			if(arrayA.get(i).get(5).equals("MP3")){
				MP3 a = new MP3(arrayA.get(i).get(0),arrayA.get(i).get(1),arrayA.get(i).get(3),arrayA.get(i).get(2),arrayA.get(i).get(5));
				audioProducts.add(a);
			}
			else{
				CD b = new CD(arrayA.get(i).get(0),arrayA.get(i).get(1),arrayA.get(i).get(3),arrayA.get(i).get(2),arrayA.get(i).get(5));
				audioProducts.add(b);
			}
		}
	}
	public void getReadables() throws FileNotFoundException{
		getArrayR();
		for(int i=0;i<arrayR.size();i++){
			if(arrayR.get(i).get(5).equals("Book")){
				Book c = new Book(arrayR.get(i).get(0),arrayR.get(i).get(1),arrayR.get(i).get(3),arrayR.get(i).get(2),arrayR.get(i).get(5));
				readables.add(c);
			}
			else{
				eBook d = new eBook(arrayR.get(i).get(0),arrayR.get(i).get(1),arrayR.get(i).get(3),arrayR.get(i).get(2),arrayR.get(i).get(5));
				readables.add(d);
			}
		}
	}
	public  int currentPage; // the page number (p1..p10)
	public int getCurrentPage() {//This method is for page navigation. Based on the values of the state variable, call different pages.
		return currentPage;
	}
	public  int changeCurrentPage(int nextPage) throws FileNotFoundException, IOException{//This method is for page navigation. It should change to current page and show the content.
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
	public   void page1() throws FileNotFoundException, IOException{	
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

	public  void page2() throws FileNotFoundException, IOException{
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
	public  void page3() throws FileNotFoundException, IOException {								//page 3

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
	public  void page4() throws FileNotFoundException, IOException{						//page 4 pretty self explanitory
		System.out.println("No Access");
		changeCurrentPage(1);							//to page 1
	}
	public   boolean isInFile(String input, String infile){//subject to change, useful for checking if a string is in a file
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

	public  void page5() throws FileNotFoundException, IOException{
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
		else System.out.println("Please enter a valid input");
		x.close();
	}
	public  void page6() throws FileNotFoundException, IOException{			
		System.out.println("1. arrayR");
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
	public  void page7() throws FileNotFoundException, IOException{
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
	public  ArrayList<ArrayList<String>> read4SaleTxt(String txtFile,String type,String txtFile2,String type2) throws FileNotFoundException{
		String token = "";															//creates empty string
		Scanner inFile = new Scanner(new File(txtFile)).useDelimiter(", |\n");		//new scanner that stops every time it reaches ", " or a new line character
		ArrayList<ArrayList<String>> contentsf = new ArrayList<ArrayList<String>>();//2d array list to store all contents
		while(inFile.hasNext()){													//while loop going through the intended file
			ArrayList<String> contents = new ArrayList<String>();					//create 1d arraylist to store the info strings in
			for(int i=0;i<5;i++){													//only 5 strings needed so go through exactly 5 times
				token = inFile.next();												//grabs strings in order
				contents.add(token);												//add each string the 1d arraylist
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
				contents.add(token);												//add each string the 1d arraylist
			}
			contents.add(type2);
			contentsf.add(contents);												//add the 1d arraylists to the 2d arraylist to use all of them after
		}
		inFile2.close();
		return contentsf;														//return all info
	}
	public  void page8() throws IOException{			//page 8
		System.out.print("Choose your option:");			//prints to screen
		showReadables();
		Scanner a = new Scanner(System.in);
		String p8choice1 = a.next();
		
	}
	public  void page9() throws IOException{			//page9
		System.out.println("Choose your option:");			//prints to screen
		showAudioProducts();
		Scanner a = new Scanner(System.in);
		String p8choice1 = a.next();
		int A = -1;
		if(p8choice1.equals("0")){changeCurrentPage(10);}
		else if(p8choice1.equals("-1")){changeCurrentPage(6);}
		else{
			for(int i=0;i<arrayA.size();i++){
				if(arrayA.get(i).get(0).equals(p8choice1)){
					A = i;
				}
			}
			if(A==-1){System.out.println("Please enter a valid input");changeCurrentPage(8);}
			else{
				
			}
		}
	}
}	

