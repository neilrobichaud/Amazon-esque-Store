
public class eBook extends Readable{												//ebook class
public String type;																	//type string
	public eBook(String a,String b,String c,String d,String f) {					//constructor
		super(a,b,c,d);																//calls super
		this.type = f;																//sets type
	}
	@Override
	public int getPrice(){															//price getter
		return super.getPrice();													//returns parent class get price
	}
}
