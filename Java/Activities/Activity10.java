import java.util.HashSet;

public class Activity10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> hs=new HashSet(); 
		hs.add("Preeti");
		hs.add("Rini");
		hs.add("Karran");
		hs.add("Saroo");
		hs.add("Mohan");
		hs.add("Divya");
		System.out.println("Size of hashset:" + hs.size());
		System.out.println("removed name karran?" + hs.remove(2));
		if (hs.remove(7)) {
			System.out.println("Element Removed");
		}
		else {
			System.out.println("Element not present to be removed");
		}
		System.out.println("Element Prem Present or not:" + hs.contains("Prem"));
		System.out.println("Updated hashSet:"+ hs);
	}

}
