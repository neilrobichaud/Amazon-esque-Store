import java.io.*;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class ShoppingCart extends User{

	private static ArrayList<String> content = new ArrayList<String>(); //array of items
	static String cartname = getUsername() + "_cart.txt";
	public static ArrayList<String> getContent() throws FileNotFoundException, IOException{ //return the content of the shopping cart.		
		try (BufferedReader br = new BufferedReader(new FileReader(cartname))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       content.add(line);
		    }
		    
		}
		return content;
	}
	public static void addItem(int serialNo, String itemname, int quantity) throws FileNotFoundException, IOException{				//addItem takes a serialNo and a quantity and adds that item to the users cart.
		try (BufferedReader br = new BufferedReader(new FileReader(cartname))) {	//new filereader
		    String line;															//line string
		    String updatedline="";													//updated line
		    Boolean found=false;													//does the item already exist in the cart?
		    
		    while ((line = br.readLine()) != null) {
		    	String[] parts = line.split(",");							//splits line into a list at comma
		    	if (Integer.parseInt(parts[0]) == serialNo){				//if the first value in the list is equal to the serial number
		    		parts[3]=Integer.toString(Integer.parseInt(parts[3]) + quantity);		//the quantity string is updated
		    		for (int i=0;i<parts.length-1;i++){										//loops through parts except for last part
		    			updatedline= updatedline + parts[i] + "," ;							//concatenates each string to updatedline
		    		}
		    		updatedline=updatedline+parts[parts.length-1];							//concatenates the final value, done this way to ensure proper comma placement
		    		
		    		try {
			    		BufferedReader file = new BufferedReader(new FileReader(cartname));		//read cart
			            String line1;String input = "";											//create two string variables
			            while ((line1 = file.readLine()) != null) input += line1 + '\n';		//read contents of cart into input
			            file.close();															//close cart
			            input=input.replace(line, updatedline);									//update input
			            FileOutputStream fileOut = new FileOutputStream(cartname);				//overwrite cart
			            fileOut.write(input.getBytes());										//write input
			            fileOut.close();														//close new cart file
			    	    } catch (Exception e) {
			    	        System.out.println("Problem reading file.");
			    	    }
		            found=true;
		            break;
		    	}		    	
		    }
		    
		    if (found == false){
		    	Writer output = new BufferedWriter(new FileWriter(cartname, true));
		    	
		    	// Display a date in day, month, year format
		    	Date date = Calendar.getInstance().getTime();		    	
		    	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		    	String today = formatter.format(date);
		    	
		    	output.append("\n"+serialNo+","+itemname.toString()+","+today+","+quantity);//find way to display info from serial number using getInfo method, alternate option is to use item name as input instead which would require changing of update function 
		    	//sn,name,date,quantity
		    	output.close();
		    }
		    
		}

		//search username_cart.txt for matching serial number
		//if found add quantity, if not create new line with the item
	}
}
