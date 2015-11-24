
public abstract class Item {
	public abstract String getInfo(String a,String b, String c, String d, String e,String f);	//go into textfile AND find serialno;		
	public abstract int getPrice();																//abstract getr price
	protected int price;																		//int pri
	protected int sNo;																			//serial number
	protected String name;																		//name
	public Item(String a, String b,String c){													//item constructor
		this.sNo = Integer.parseInt(a);															//sets serial no
		this.name = b;																			//sets name
		this.price = Integer.parseInt(c);														//sets price
		}
}
