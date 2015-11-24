
public class MP3 extends Audio{												//mp3 class
	
	public String type;														//string type
	public MP3(String a,String b,String c,String d,String f){				//constructor for mp3
		super(a,b,c,d);														//calls parent class method
		this.type = f;														//sets typoe
	}
	@Override
	public int getPrice(){													//getter for price
		return super.getPrice();											//returns price
	}
}
