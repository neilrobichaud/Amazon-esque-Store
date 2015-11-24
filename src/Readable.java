
public class Readable extends Item{																	//readable cl
	protected String authorName;																	//authors name
	public Readable(String a,String b,String c,String d){											//readable constructor
		super(a,b,c);																				//calls superconstructor
		this.authorName = d;																		//sets the author name
	}
	public String getInfo(String a,String b,String c,String d,String e,String f){					//getInfo
		return a+", "+b+", "+c+", "+d+", "+e+", "+f;												//returns a concanetad string
	}
	@Override	
	public int getPrice(){																			//getter for price
		return price;																				//returns price
	}
}
