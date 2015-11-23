import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class HWK4_robichne {

	public static void main(String[] args) throws FileNotFoundException {
		File users, books, ebooks, mp3, cds; users = new File("Users.txt"); books = new File("Books.txt"); ebooks = new File("Ebooks.txt");mp3 = new File("MP3.txt"); cds = new File("CDs.txt");
		try {
			users.createNewFile(); books.createNewFile(); ebooks.createNewFile(); mp3.createNewFile(); cds.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		UserInterface ui = new UserInterface();
	}
}
