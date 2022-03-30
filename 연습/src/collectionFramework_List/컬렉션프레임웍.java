package collectionFramework_List;

//import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public class 컬렉션프레임웍 {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList(10);
		list1.add(5);
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		print(list1, list2);
		System.out.println("=========");
		
		list1.add(555);
		list2.set(2, list1);
		print(list1, list2);
		System.out.println("=========");

		Collections.sort(list1);
		print(list1, list2);
	}
	
	static void print(ArrayList list1, ArrayList list2){
		System.out.println("list1: " + list1);
		System.out.println("list2: " + list2);
	}
}

