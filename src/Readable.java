
public class Readable extends Item{
	protected String authorName;
	public String getInfo(){
		return Integer.toString(sNo);
	}
	
	@Override
	public int getPrice(){
		return 12;
	
	}
	protected int price;
	protected int sNo;
}
