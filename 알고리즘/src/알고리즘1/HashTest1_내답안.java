package 알고리즘1;

import java.util.HashMap;

public class HashTest1_내답안 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
         
        HashMap mapC = new HashMap();
        
        for(int i=0; i<completion.length; i++){
        	if(mapC.containsKey(completion[i])){
                Integer count=(Integer)mapC.get(completion[i]);
                mapC.put(completion[i],count+1);    
            }else{
                mapC.put(completion[i],new Integer(1));
            }
        }
        
        for(int i=0; i<participant.length; i++){
        	boolean key = mapC.containsKey(participant[i]);
        	Integer count=(Integer)mapC.get(participant[i]);
        	if(key && count!=0){
                mapC.put(participant[i],--count);
                System.out.println("next : "+participant[i]+" , "+(Integer)mapC.get(participant[i]));
        	}else {
        		answer = participant[i];
        	}
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
		HashTest1_내답안 h = new HashTest1_내답안();
		
		String[] p= {"mislav", "stanko", "mislav", "ana"};
		String[] c = {"stanko", "ana", "mislav"};
		
		
		System.out.println(h.solution(p, c));
	}
}