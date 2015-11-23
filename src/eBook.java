
public class eBook extends Readable{
public String type;
	public eBook(String a,String b,String c,String d,String f) {
		super(a,b,c,d);
		this.type = f;
	}
	@Override
	public int getPrice(){
		return super.getPrice();
	}
}
