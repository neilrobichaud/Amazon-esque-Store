import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class UserInterface {
	public  void main(String args[]){
		page1();
	}
	private Array readables;
	private Array audioProducts;
	private int currentPage; // the page number (p1..p10)
	public int getCurrentPage() {//This method is for page navigation. Based on the values of the state variable, call different pages.
		return currentPage;
	}
	public  int changeCurrentPage(int nextPage){//This method is for page navigation. It should change to current page and show the content.
		if (nextPage == 1){page1();}
		if (nextPage == 2){page2();}
		if (nextPage == 3){page3();}
		if (nextPage == 4){page4();}
		if (nextPage == 5){page5();}
		if (nextPage == 6){page6();}
		if (nextPage == 7){page7();}
//		if (nextPage == 8){page8();}
//		if (nextPage == 9){page9();}
//		if (nextPage == 10){page10();}
		return nextPage;
	}
	public void getReadables(){} // fetches all readables from the files and places them in the readables array
	public void showAudioProducts(){} //Displays all audio products for browsing.
	
	
	public  void page1(){	
		File users, books, ebooks, mp3, cds; users = new File("Users.txt"); books = new File("Books.txt"); ebooks = new File("Ebooks");mp3 = new File("MP3.txt"); cds = new File("CDs.txt");
		try {
			users.createNewFile(); books.createNewFile(); ebooks.createNewFile(); mp3.createNewFile(); cds.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Scanner a = new Scanner(System.in);
		int p1choice;
		System.out.println("1.Sign in");
		System.out.println("2.Sign up");
		System.out.print("Choose your option:");
		p1choice = a.nextInt();
		if(p1choice==1){
			changeCurrentPage(3);
		}
		else if(p1choice==2){
			changeCurrentPage(2);
		}
	}
	private  void page2(){
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
				changeCurrentPage(1);								//to page 1
				}
			catch (IOException e) {
			e.printStackTrace();
			}
		}
	}
	private  void page3() {								//page 3
		Scanner a = new Scanner(System.in);				//create input scanner
		String p3choice;
		System.out.print("Enter your username:");		//prints to screen
		p3choice = a.next();
		if(isInFile(p3choice, "Users.txt")){			//check if the username is in the file
			System.out.println("Hello " + p3choice);	//prints to screen
			changeCurrentPage(5);						//to page 5
		}
		else{											//if not in file
			changeCurrentPage(4);						//to page 4
		}
	}
	private  void page4(){						//page 4 pretty self explanitory
		System.out.println("No Access");
		changeCurrentPage(1);					//to page 1
	}
	private  boolean isInFile(String input, String infile){//subject to change, useful for checking if a string is in a file
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
	private  void page5(){	
		System.out.println("1.View items by category");
		System.out.println("2.view shopping cart");
		System.out.println("3.sign out");
		System.out.println("4.view previous orders");
		System.out.println("Choose your option");			
		
		
		Scanner x = new Scanner(System.in);			//scanner
		String p5choice = x.next();
		if (p5choice == "1") 
			changeCurrentPage(6);
		else if (p5choice == "2") 
			changeCurrentPage(7);
		else if (p5choice == "3") 
			changeCurrentPage(1);
		else if (p5choice == "4")
			changeCurrentPage(11);
		else System.out.println("Please enter a valid input");
		x.close();
	}
	private  void page6(){			
		System.out.println("1. Readables");
		System.out.println("2. Audio");
		System.out.println("Choose your option");
		System.out.println("Press -1 to return to previous menu");
		
		Scanner x = new Scanner(System.in);			//scanner
		String p6choice = x.next();		
					
		if (p6choice == "1")
			changeCurrentPage(8);
		else if (p6choice == "2") 
			changeCurrentPage(9);
		else if (p6choice == "-1") 
			changeCurrentPage(5);
		else System.out.println("Please enter a valid input");
		
		x.close();
		}
	private  void page7(){
		//TODO print contents of uname1_cart.txt
		FileReader in = null;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       // process the line.
		    }
		}
		finally{
			if (in !=null){
				in.close();
			}
		}
		
		System.out.println("Press -1 to return to previous menu");
		Scanner x = new Scanner(System.in);			//scanner
		String p7choice = x.next();	
		
		if (p7choice == "-1")
			changeCurrentPage(5);
		else System.out.println("Please enter a valid input");
		
		x.close();
	}
}	
