import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test1 {
	//to count number of names starting with D
	//@Test
	public void regular() {
		// TODO Auto-generated method 
		
		ArrayList<String> names=new ArrayList<String>();
		names.add("Rose");
		names.add("Lily");
		names.add("Daffodil");
		names.add("Daisy");
		names.add("Lotus");
		names.add("Jasmine");
		int count=0;
		for(int i=0; i<names.size(); i++)
		{
			String actualname=names.get(i);
			if(actualname.startsWith("D"))
			{
				count++;
			}
		}
		System.out.println(count);
	}
	
	//@Test
	public void streamfilter() {
		// TODO Auto-generated method 
		
		ArrayList<String> names=new ArrayList<String>();
		names.add("Rose");
		names.add("Lily");
		names.add("Daffodil");
		names.add("Daisy");
		names.add("Lotus");
		names.add("Jasmine");
		
		long c=  names.stream().filter(s->s.startsWith("D")).count();
		//System.out.println(c);
		long d= Stream.of("Rose","Lily","Daffodil","Daisy","Lotus","Jasmine").filter(s->
		{
			return s.startsWith("D");
		}).count();
		System.out.println(d);
		//print all names in the arraylist
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		//to limit result to be shown
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	}
	
	//@Test
	public void streammap()
	{
		ArrayList<String> names1=new ArrayList<String>();
		names1.add("Rose");
		names1.add("Lily");
		names1.add("Daffodil");
		//print name which ends with 'y' to uppercase
		Stream.of("Rose","Lily","Daffodil","Daisy","Lotus","Jasmine").filter(s->s.endsWith("y")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//print name which start with letter D in uppercase & sorted
		List<String> names=Arrays.asList("Rose","Lily","Daffodil","Daisy","Lotus","Jasmine");
		names.stream().filter(s->s.startsWith("D")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//to merge 2 lists
		Stream<String> connstring=Stream.concat(names1.stream(), names.stream());
		//connstring.sorted().forEach(s->System.out.println(s));
		boolean flag=connstring.anyMatch(s->s.equalsIgnoreCase("Lily"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	
	@Test
	public void streamcollections()
	{
		List<Integer> values=Arrays.asList(3,5,5,7,8,2,4,6,9,9);
		//print the unique number from array
		//sort the array
		//values.stream().distinct().forEach(s->System.out.println(s));
		//sort & show 3rd value from sorted list
		List<Integer> numlist=  values.stream().sorted().collect(Collectors.toList());
		System.out.println(numlist.get(2));
		
	}
}
