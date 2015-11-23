
public abstract class Item {
	public abstract String getInfo(String a,String b, String c, String d, String e,String f);	//go into textfile AND find serialno;		
	public abstract int getPrice();
	protected int price;
	protected int sNo;
	protected String name;
	public Item(String a, String b,String c){
		this.sNo = Integer.parseInt(a);
		this.name = b;
		this.price = Integer.parseInt(c);
		}
}
