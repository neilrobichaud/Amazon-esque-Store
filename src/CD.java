
public class CD extends Audio{
	public String type;

	public CD(String a,String b,String c,String d,String f){
		super(a,b,c,d);
		this.type = f;
	}
	@Override
	public int getPrice() {
		return price + price/50;
	}
}
