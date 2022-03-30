package 알고리즘1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Test111 {
	public String solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
      
      //HashMap mapRpt : 신고당한 유저 레코드 (key: 신고당한 유저 / val: 횟수) => 조회시 val이 k번 이상이면.
      //HashMap mapUsr : 신고한 사람 레코드 (key: 신고당한 유저 / val: 신고한 유저) => k번 이상인 key값의 val 추출 => sendE_U에 add
      //ArrayList sendE_U : 발송메일 받을 유저 => E_count에 put (key값 이미 존재시 val count++)
      //HashMap E_count : 유저별 발송횟수
      //answer : 각 유저별 처리결과 메일 받은 횟수 (id_list에 담긴 id 순서대로)
        
        HashMap mapRpt = new HashMap();//신고 레코드
        HashMap mapUsr = new HashMap();//신고한 사람 레코드 (신고당한유저: 신고한 유저들)
        List sendE_U = new ArrayList();//문자 발송 받을 사람 리스트 
        HashMap E_count = new HashMap();//유저별 문자발송 횟수
        
        Set<String> setRpt = new HashSet(Arrays.asList(report)); //중복제거
//        System.out.println(setRpt);
        Iterator<String> it = setRpt.iterator();
        while(it.hasNext()){
        	String tmp =it.next();
//        	System.out.println("next record: "+tmp);
        	int idx = tmp.indexOf(" ");
        	String userR = tmp.substring(0,idx);//신고한 유저
        	String userB = tmp.substring(idx+1);//신고 당한 유저
        	if(!userR.equalsIgnoreCase(userB)){
        		
        		if(mapRpt.containsKey(userB)){
        			Integer val = (Integer) mapRpt.get(userB);
        			mapRpt.put(userB, val+1);
        			//신고한 사람 레코드에 추가 
        			String rUsr = (String) mapUsr.get(userB);
        			mapUsr.put(userB, rUsr.concat(" "+userR));
        			
        			if(val>=1){
        				//해당유저 정지 
//        			System.out.println(userB+" 정지");
        				//k번 이상인 key값의 val 추출 => sendE_U에 add
        				String tmpUsr=(String)mapUsr.get(userB);
        				String[] getEusr = tmpUsr.split(" ");
        				for(String s: getEusr){
        					sendE_U.add(s);
        				}	
        			}
        		}else {
        			mapRpt.put(userB, new Integer(1)); //신고당한 횟수추가
        			mapUsr.put(userB, userR); //신고한 사람 레코드에 추가
        		}
        	}
        }
        for(int i=0; i<sendE_U.size(); i++){ 
        	String usrN = (String) sendE_U.get(i);
        	if(E_count.containsKey(usrN)){
        		Integer n = (Integer) E_count.get(usrN);
        		E_count.put(usrN, n+1);
        	}else {
        		E_count.put(usrN, 1);
        	}
        }
        
        for(int i=0; i<id_list.length; i++){
        	try {
        		int num=(Integer) E_count.get(id_list[i]);
//        		System.out.println("num: "+num);
        		
        		answer[i]=num;
        		System.out.println("answer["+i+"]: "+answer[i]);
			} catch (Exception e) {
				answer[i]=0;
				System.out.println("answer["+i+"]: "+answer[i]);
			}
        }
        
        System.out.println(mapRpt);
        System.out.println("신고한 사람 레코드 (신고당한유저: 신고한 유저들): "+ mapUsr);
        System.out.println("이메일 발송 받을 유저들 리스트: "+sendE_U);
        System.out.println("유저별 이메일 발송 횟수: "+E_count);
        
        String answer1 = Arrays.toString(answer) ;
        return answer1;
    }	
	
	
	public static void main(String[] args) {
		Test111 h = new Test111();
		
		String[] p= {"muzi", "frodo", "apeach", "neo"};
		String[] c = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi","muzi muzi"};
		int k =3;
//		["muzi", "frodo", "apeach", "neo"]	["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]
		System.out.println(h.solution(p, c, k));
	}
	
}
