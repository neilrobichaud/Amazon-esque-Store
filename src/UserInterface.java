import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
	private Array readables;
	private Array audioProducts;
	private int currentPage; // the page number (p1..p10)
	public int getCurrentPage() {//This method is for page navigation. Based on the values of the state variable, call different pages.
		return currentPage;
	}
	public int changeCurrentPage(int nextPage){//This method is for page navigation. It should change to current page and show the content.
		if (nextPage == 1){page1();}
		if (nextPage == 2){page2();}
		if (nextPage == 3){page3();}
		if (nextPage == 4){page4();}
		if (nextPage == 5){page5();}
		if (nextPage == 6){page6();}
		if (nextPage == 7){page7();}
		if (nextPage == 8){page8();}
		if (nextPage == 9){page9();}
		if (nextPage == 10){page10();}
	}
	public void getReadables(){} // fetches all readables from the files and places them in the readables array
	public void showAudioProducts(){} //Displays all audio products for browsing.
	public void page1(){	
		Scanner a = new Scanner(System.in);
		int p1choice;
		System.out.println("1.Sign in");
		System.out.println("2.Sign up");
		System.out.print("Choose your option:");
		s = a.nextInt();
		if(p1choice==1){
			changeCurrentPage(3);
		}
		else if(p1choice==2){
			changeCurrentPage(2);
		}
	}
	private static void page2(){
		System.out.print("Choose your username:");
		File file = new File("Users.txt");
		Scanner a = new Scanner(System.in);
		String p2choice = a.next();
		FileWriter write;
		if(isInFile(p2choice, "Users.txt")){
			System.out.println("That username already exists");
			changeCurrentPage(1);
		}
		else{
			try {
				write = new FileWriter(file, true);
				BufferedWriter buffer = new BufferedWriter(write);
				if (file.length() != 0){
					buffer.newLine();
					buffer.write(p2choice);
				}else{
					buffer.write(p2choice);
				}
				buffer.close();
				System.out.println("Username successfully added");
				changeCurrentPage(1);
				}
			catch (IOException e) {
			e.printStackTrace();
			}
		}
	}
	private static void page3() {
		Scanner a = new Scanner(System.in);
		String p3choice;
		System.out.print("Enter your username:");
		p3choice = a.next();
		if(isInFile(p3choice, "Users.txt")){
			System.out.println("Hello " + p3choice);
			changeCurrentPage(5);
		}
		else{
			changeCurrentPage(4);
		}
	}
	private static void page4(){
		System.out.println("No Access");
		changeCurrentPage(1);
	}
	private static boolean isInFile(String input, String infile){
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
	
}	
