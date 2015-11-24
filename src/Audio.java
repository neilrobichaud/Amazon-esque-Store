
public class Audio extends Item{			//extends item

	public String artistname;				//artistname

	
	public Audio(String a,String b,String c,String d){	//when you make any item you need 4 strings
		super(a,b,c);									//calls superconstructor
		this.artistname = d;							//artistname is d
	}
	@Override
	public String getInfo(String a,String b,String c,String d,String e,String f) {	//getinfo takes 6 strings
		return a+", "+b+", "+c+", "+d+", "+e+", "+f;								//returns them  concatenated
	}

	@Override
	public int getPrice() {														//get price
		return price;															//returns price
	}
}
