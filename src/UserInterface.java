import java.lang.reflect.Array;
import java.util.Arrays;

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
		 
		System.out.println("1. Sign in");
		System.out.println("2. Sign up");
		System.out.println("Choose your option");
	}
	
}	
