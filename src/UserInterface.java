import java.lang.reflect.Array;
import java.util.Arrays;

public class UserInterface {
	private Array readables;
	private Array audioProducts;
	private int currentPage; // the page number (p1..p10)
	public int getCurrentPage(..) {//This method is for page navigation. Based on the values of the state variable, call different pages.
		
	}
	public int changeCurrentPage(..){//This method is for page navigation. It should change to current page and show the content.
	
	}
	public void getReadables(){} // fetches all readables from the files and places them in the readables array
	public void showAudioProducts(){} //Displays all audio products for browsing.
	public void page1(){	
		 
		System.out.println("1. Sign in");
		System.out.println("2. Sign up");
		System.out.println("Choose your option");
	}
}	
k