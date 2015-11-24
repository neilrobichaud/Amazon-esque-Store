
public class Book extends Readable{				//book class
	
	public String type;							//type
	
	public Book(String a, String b, String c, String d, String f) {		//takes 5 args
		super(a, b, c, d);												//calls superconstructor
		this.type = f;													//this type 
	}
	@Override															//override
	public int getPrice(){												//getprice method
		return price + price/50;										//calculates the tax
	}


}
