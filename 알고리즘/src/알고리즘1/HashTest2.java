package 알고리즘1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class HashTest2 {
	public boolean solution(String[] phone_book) {
		boolean answer = true;
        HashMap<String, Integer> pb = new HashMap();

        for(int i=0; i<phone_book.length; i++){
            String num = phone_book[i];
        	if(num.length()!=1){
                pb.put(num, 1);
            }
        }
        System.out.println(pb);

    	for(int i=0; i<phone_book.length; i++){
    		String val = phone_book[i];
    		System.out.println("cur Pnum: "+val);			
			for(Map.Entry<String, Integer> entry : pb.entrySet()){
    			String key = entry.getKey();
    			String subKey = key.substring(0,val.length());
				if(key.contains(val)&&key!=val && subKey.equals(val)){
					System.out.println("일단 포함: "+key);
//    				if(key!=val && subKey.equals(val)){
    					System.out.println("포함: "+ entry.getKey()+" || "+ phone_book[i]);
    					
    					answer=false;
    					break;    					
//    				}
    			}
    		}	
        	if(answer==false) break;
        }
        
        return answer;
	}
	 public static void main(String[] args) {
			 HashTest2 h = new HashTest2();
			
			String[] p= { "33", "119", "97674223", "1195524421", "123", "123456", "1234555", "567", "9876"};			
			System.out.println(h.solution(p));
		}
}
