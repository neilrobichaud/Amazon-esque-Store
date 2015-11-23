
public class User{
	private static String username;	
	public static String getUsername(){
		return username;
	}
	private static boolean isAdmin=false;
	
	public User(String name){
		username=name;	//should add username to users.txt
	}
	public static boolean adminStatus(){	//getter for isAdmin
		if (username.equals("ADMIN")){
			isAdmin=true;
		}
		return isAdmin;
		
	}
}
