
public class Readable extends Item{
	protected String authorName;
	public Readable(String a,String b,String c,String d){
		super(a,b,c);
		this.authorName = d;
	}
	public String getInfo(String a,String b,String c,String d,String e,String f){
		return a+", "+b+", "+c+", "+d+", "+e+", "+f;
	}
	@Override
	public int getPrice(){
		return price;
	}
}
