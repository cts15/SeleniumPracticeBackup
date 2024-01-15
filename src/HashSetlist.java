import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> list=new HashSet<String>();//Creating arraylist  
		list.add("India");//Adding object in arraylist  
		list.add("UK");  
		list.add("USSA");  
		list.add("Russia"); 
		list.add("Pacific");
		list.add("Atlantic");
		System.out.println(list);  
		
		System.out.println(list.contains("test"));
	
		
		System.out.println(list.isEmpty());
		
		System.out.println(list.size());
		
		Iterator<String> itr=list.iterator();  
		while(itr.hasNext())
		{  
		System.out.println(itr.next());  
		
		}  
	}

}
