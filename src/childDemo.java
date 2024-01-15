
public class childDemo extends parentDemo
{
	String name ="QAClickAcademy";
	public childDemo()
	{
		super();
		System.out.println("child class constructor");
	}
	
	public void getStringdata()
	{
		System.out.println(name);
		System.out.println(super.name);
	}
	
	
	public void getData()
	{
		super.getData();
		System.out.println("I am child demo");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		childDemo cd= new childDemo();
		cd.getStringdata();
		cd.getData();

	}

}



