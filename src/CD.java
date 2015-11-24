
public class CD extends Audio{													//cd class
	public String type;															//string type

	public CD(String a,String b,String c,String d,String f){					//constructor for cd
		super(a,b,c,d);															//calls parent class 
		this.type = f;															//sets type 
	}
	@Override
	public int getPrice() {														//price getter
		return price + price/50;												//calculates tax
	}
}
