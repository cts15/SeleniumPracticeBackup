import java.util.ArrayList;
import java.util.Iterator;

public class Arraylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list=new ArrayList<String>();//Creating arraylist  
		list.add("Ravi");//Adding object in arraylist  
		list.add("Vijay");  
		list.add("Ravi");  
		list.add("Ajay");  
		System.out.println(list);  
		
		list.add(0,"Student");
		System.out.println(list);
		  
		//list.remove(1);
		//System.out.println(list);
		
		System.out.println(list.get(2));
		
		System.out.println(list.contains("test"));
		
		System.out.println(list.indexOf("Vijay"));
		
		System.out.println(list.isEmpty());
		
		System.out.println(list.size());
	}

}
