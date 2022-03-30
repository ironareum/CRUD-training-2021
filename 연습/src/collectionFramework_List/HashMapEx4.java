package collectionFramework_List;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapEx4 {
	public static void main(String[] args) {
		String[] data = {"A", "K", "A", "K", "D", "K", "A", "K", "K","K","Z", "D"};
		
		HashMap map = new HashMap();
		
		for(int i=0; i<data.length; i++){
			if(map.containsKey(data[i])){
				Integer num=(Integer)map.get(data[i]);
				map.put(data[i], new Integer(num.intValue()+1));
			}else {
				map.put(data[i],new Integer(1));
			}
		}
		
		System.out.println(map);
		Iterator it = map.entrySet().iterator(); //set
		while(it.hasNext()){
			Map.Entry entry =(Map.Entry) it.next(); //map
			
			
		}
	}
}
