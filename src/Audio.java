
public class Audio extends Item{

	public String artistname;

	
	public Audio(String a,String b,String c,String d){
		super(a,b,c);
		this.artistname = d;
	}
	@Override
	public String getInfo(String a,String b,String c,String d,String e,String f) {
		return a+", "+b+", "+c+", "+d+", "+e+", "+f;
	}

	@Override
	public int getPrice() {
		return price;
	}
}
