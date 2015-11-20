import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ShoppingCart extends User{
	static ArrayList<String> content = new ArrayList<String>(); //array of items
	public static ArrayList<String> getContent() throws FileNotFoundException, IOException{ //return the content of the shopping cart.
		String cartname = UserInterface.username + "_cart.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(cartname))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       content.add(line);
		    }
		    
		}
		return content;
	}
	//public addItem(){}
	

}
