
public class StaticVar {
	
	//instance variables
	String name;
	String address;
	//class variables
	static String city;
	static int i;
	static {
		city="Surat";
		i=0;
	}
	
	StaticVar(String name,String address)
	{
		this.name=name;
		this.address=address;
		i++;
		System.out.println(i);
	}
	
	//instance methods
	public void getAddress()
	{
		System.out.println(address+" "+city);
	}
	
	//class methods
	public static void getCity()
	{
		System.out.println(city);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticVar obj=new StaticVar("Tom","ParlePoint");
		StaticVar obj1 =new StaticVar("Nick","Adajan");
		StaticVar obj2 =new StaticVar("Mickey","LPSavaniRoad");
		
		obj.getAddress();
		obj1.getAddress();
		StaticVar.getCity();
		StaticVar.i=4;
		obj.address="XYZ";

	}

}
