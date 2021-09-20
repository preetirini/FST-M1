import java.util.ArrayList;
import java.util.List;

public class Activity9 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> myList = new ArrayList<String>();
		myList.add("One");
		myList.add("Two");
		myList.add("Three");
		
		myList.add("Four");
		myList.add("Five");
		
		System.out.println("Size of arraylist:" + myList.size());
		myList.remove(2);
		System.out.println("Size of arraylist after removing a name:" + myList.size());
	myList.forEach((n)->printNames(n));
	
	System.out.println("Third Name in Array: "  + myList.get(2));
	boolean compare = myList.contains("Six");
	
	if (compare) {
System.out.println("List Contains Six");

	}
	else {
		System.out.println("List doesnot Contains Six");
	}
	
	}
	
	public static void printNames (String n) {
		System.out.println(n);
	}
	
	

}
