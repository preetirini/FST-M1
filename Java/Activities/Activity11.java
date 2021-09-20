import java.util.HashMap;
import java.util.Map;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map colours=new HashMap();  
		colours.put(1, "Blue");
		colours.put(2, "Yellow");
		colours.put(3, "Orange");
		colours.put(4, "Pink");
		colours.put(5, "green");
        System.out.println("Removing color pink:" + colours.remove(4));
        if(colours.containsValue("green"))
        {
        	System.out.println("Contains green");
        }
        else
        {
        	System.out.println("Does not contain green");
        }
        System.out.println("Size of the map:" + colours.size());
        
	}

}
