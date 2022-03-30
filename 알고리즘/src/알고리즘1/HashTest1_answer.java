package 알고리즘1;

import java.util.HashMap;
import java.util.Map;

public class HashTest1_answer {
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
                break;
            }
        }
        for (Map.Entry<String, Integer> entry : hm.entrySet()){
        	if(entry.getValue()!=0){
        		answer = entry.getKey();
        		break;
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
