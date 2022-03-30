package collectionFramework_List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TreemapEx1 {
	public static void main(String[] args) {
		String[] data = {"A", "K", "A", "K", "D", "K", "A", "K", "K","K","Z", "D"};
		TreeMap map = new TreeMap();
		
		for(int i=0; i<data.length; i++){
			if(map.containsKey(data[i])){
				Integer num=(Integer)map.get(data[i]);
				map.put(data[i], new Integer(num.intValue()+1));
			}else {
				map.put(data[i],new Integer(1));
			}
		}
		
		Iterator it = map.entrySet().iterator();
		System.out.println("기본정렬 ====");
		while(it.hasNext()){
			Map.Entry entry=(Map.Entry) it.next();
			int val=(Integer) entry.getValue();
			System.out.println(entry.getKey()+" : "+ printBar('#',val)+" "+entry.getValue());
		}		
		System.out.println();
		List list = new ArrayList(map.entrySet());
		for(int i=0; i<list.size(); i++){
			Collections.sort(list, new Comp());
		}
		System.out.println("값의 크기가 큰 순서로 정렬====");
		
		
		
	}
	
	static class Comp implements Comparator{
		@Override
		public int compare(Object o1, Object o2) {
			if(o1 instanceof Map.Entry && o2 instanceof Map.Entry){
				Map.Entry e1=(Map.Entry)o1;
				Map.Entry e2=(Map.Entry)o2;
				int n1=(Integer) e1.getValue();
				int n2=(Integer) e2.getValue();
				return n1-n2;
			}
			return -1;
		}		
	}
	
	
	public static String printBar(char ch, int val){
		char[] bar = new char[val];
		for(int i=0; i<bar.length; i++){
			bar[i]=ch;
		}
		return new String(bar);
	}
}
