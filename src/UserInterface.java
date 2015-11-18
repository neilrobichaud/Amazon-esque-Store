import java.lang.reflect.Array;
import java.util.Arrays;
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
	private void page5(){	
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
	private void page6(){			
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
	
}	
