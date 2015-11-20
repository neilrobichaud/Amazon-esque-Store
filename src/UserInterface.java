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
//		if (nextPage == 8){currentPage=nextPage;page8();}
//		if (nextPage == 9){currentPage=nextPage;page9();}
//		if (nextPage == 10){currentPage=nextPage;page10();}
		return nextPage;
	}
	public void getReadables(){} // fetches all readables from the files and places them in the readables array
	public void getAudioProducts(){} // fetches all readables from the files and places them in the readables array
	public void showReadables(){} //Displays all audio products for browsing.
	public void showAudioProducts(){} //Displays all audio products for browsing.
	
<<<<<<< HEAD
	public static  void page1(){	
=======
	
	public static  void page1() throws FileNotFoundException, IOException{	
>>>>>>> origin/gitlabhwk4
		File users, books, ebooks, mp3, cds; users = new File("Users.txt"); books = new File("Books.txt"); ebooks = new File("Ebooks");mp3 = new File("MP3.txt"); cds = new File("CDs.txt");
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
<<<<<<< HEAD
	private static void page2(){
		System.out.println();
=======
	public static void page2() throws FileNotFoundException, IOException{
>>>>>>> origin/gitlabhwk4
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
<<<<<<< HEAD
	private static void page3() {								//page 3
		System.out.println();
=======
	public static void page3() throws FileNotFoundException, IOException {								//page 3
>>>>>>> origin/gitlabhwk4
		Scanner a = new Scanner(System.in);				//create input scanner
		String p3choice;
		System.out.print("Enter your username:");		//prints to screen
		p3choice = a.next();
		if(isInFile(p3choice, "Users.txt")){			//check if the username is in the file
			System.out.println("Hello " + p3choice);	//prints to screen
			User.username=p3choice;
			changeCurrentPage(5);						//to page 5
		}
		else{											//if not in file
			changeCurrentPage(4);						//to page 4
		}
		a.close();
	}
<<<<<<< HEAD
	private static void page4(){						//page 4 pretty self explanitory
		System.out.println();
=======
	public static void page4() throws FileNotFoundException, IOException{						//page 4 pretty self explanitory
>>>>>>> origin/gitlabhwk4
		System.out.println("No Access");
		changeCurrentPage(1);							//to page 1
	}
<<<<<<< HEAD

	private static  boolean isInFile(String input, String infile){//subject to change, useful for checking if a string is in a file
=======
	public static  boolean isInFile(String input, String infile){//subject to change, useful for checking if a string is in a file
>>>>>>> origin/gitlabhwk4
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
<<<<<<< HEAD
	private static void page5(){
		System.out.println();
=======
	public static void page5() throws FileNotFoundException, IOException{
		System.out.println("\n"+ "\n");
>>>>>>> origin/gitlabhwk4
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
<<<<<<< HEAD
	private static void page6(){
		System.out.println();
=======
	public static void page6() throws FileNotFoundException, IOException{			
>>>>>>> origin/gitlabhwk4
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
<<<<<<< HEAD
	}
	private static void page8(){
		
	}
}
//	private static void page7(){
//		//TODO print contents of uname1_cart.txt
//		FileReader in = null;
//		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//	private  void page7(){
//		//TODO print contents of uname1_cart.txt
//		String uname1="ddd";
//		FileReader in = null;
//		try (BufferedReader br = new BufferedReader(new FileReader(uname1))) {
//		    String line;
//		    while ((line = br.readLine()) != null) {
//		       // process the line.
//		    }
//		}
//		finally{
//			if (in !=null){
//				in.close();
//			}
//		}
//		
//		System.out.println("Press -1 to return to previous menu");
//		Scanner x = new Scanner(System.in);			//scanner
//		String p7choice = x.next();	
//		
//		if (p7choice == "-1")
//			changeCurrentPage(5);
//		else System.out.println("Please enter a valid input");
//		
//		x.close();
//	}
	
=======
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
}	
>>>>>>> origin/gitlabhwk4
