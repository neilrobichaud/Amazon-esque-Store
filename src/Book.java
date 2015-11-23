
public class Book extends Readable{
	
	public String type;
	
	public Book(String a, String b, String c, String d, String f) {
		super(a, b, c, d);
		this.type = f;
	}
	@Override
	public int getPrice(){
		return price + price/50;
	}


}
