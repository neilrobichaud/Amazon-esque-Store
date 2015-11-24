import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class HWK4_robichne {
	public static ArrayList<Item> audioProducts;
	public static ArrayList<Item> readables;	
	public static void main(String[] args) throws IOException {									//main 
		File users, books, ebooks, mp3, cds; users = new File("Users.txt"); books = new File("Books.txt"); ebooks = new File("Ebooks.txt");mp3 = new File("MP3.txt"); cds = new File("CDs.txt"); //makes a bunch of empty text files
		try {																														//first couple of lines create the text files if they do not already exist
			users.createNewFile(); books.createNewFile(); ebooks.createNewFile(); mp3.createNewFile(); cds.createNewFile(); //trys to make new files
		} catch (IOException e) {			//catch doesnt do anything just prints stack
			// TODO Auto-generated catch block
			e.printStackTrace();		//prints stack
		} 

		UserInterface ui = new UserInterface();																						//creates a new instance of the userinterface
		audioProducts = ui.getAudioProducts();																												//makes sure the arrays are created
		readables = ui.getReadables();																												// same thing
		ui.page1();																													//begin going through the pages

	}
}
