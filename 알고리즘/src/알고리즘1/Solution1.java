package 알고리즘1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Solution1 {

    public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};
//records : 시각, 차량번호, 내역         
//기본시간 180분 , 기본요금 5000원
//단위시간 10분, 단위요금 600원
//주차요금 = if (주차시간 >180){ 기본요금 + Ceil((주차시간-기본시간)/단위시간) *단위요금}
//주차요금 = else (기본요금)
//차량번호가 작은 자동차부터 청구요금 출력 정수배열
        int Gtime = fees[0]; //기본시간(분)
        int Gfee = fees[1]; //기본요금(원)
        int Dtime = fees[2]; //단위시간(분)
        int Dfee = fees[3]; //단위요금(원)
        
        HashMap map = new HashMap();
        HashMap t_time = new HashMap();
        ArrayList in = new ArrayList();
        
        for(int i=0; i<records.length; i++){
        	String time ;
        	String car ;
        	String d ;

        	String[] tmp = records[i].split(" ");
        	time = tmp[0];
        	car = tmp[1];
        	d=tmp[2];
            System.out.print(time+" ");
            System.out.print(car+" ");
            System.out.print(d+" ");
            System.out.println();
            
            if(d.equals("IN")){
            	map.put(car, time);
            	in.add(car);
            }else if(d.equals("OUT")){
            	String inT=(String)map.get(car);//입차시간추출
            	int in_idx = inT.indexOf(":");
            	int in_h = Integer.parseInt(inT.substring(0,in_idx));
            	int in_m = Integer.parseInt(inT.substring(in_idx+1));
            	int inMins = in_h*60 + in_m;
            	System.out.println(car+" inMins: "+ inMins);
            	
            	//출차시간
            	int out_idx = time.indexOf(":");
            	int out_h = Integer.parseInt(time.substring(0,out_idx));
            	int out_m = Integer.parseInt(time.substring(out_idx+1));
            	int oMins = out_h*60 + out_m;
            	System.out.println(car+" oMins: "+ oMins);
            	
            	int p_time = oMins-inMins;//주차시간
            	 
            	map.put(car, p_time); //주차시간으로 변경  
            	
            	//당일 중복 출차시 총 주차시간 계산 
            	if(t_time.containsKey(car)){
            		int exTime=(Integer)t_time.get(car);
            		t_time.put(car, exTime+p_time);
            	}else {
            		t_time.put(car, p_time);
            	}

            	System.out.println("total Min: "+ (oMins-inMins));
            	in.remove(car);
            }
//            System.out.println("입차 차량: "+in);
        }
        
        // if(입차) => 입차 차량 map 생성 (key: 차량번호, val: 입차시간)
        // ArrayList => 입차 차량 list 생성 (출차확인용)
        // if(출차) => map에서 출차차량 조회  후 시간계산, 비용계산  후 val 값 변경. && 입차 차량 list에서 해당 차량 삭제
        // 나머지 입차 차량 list 남은 차량 주차비 계산 
        // map key 추출-> sort 해서 values 
        
        System.out.println("아직 남은 주차 차량: "+in);
        if(!in.isEmpty()){
        	for(int i=0; i<in.size(); i++){
        		String inT=(String)map.get(in.get(i));//입차시간추출
        		int in_idx = inT.indexOf(":");
        		int in_h = Integer.parseInt(inT.substring(0,in_idx));
        		int in_m = Integer.parseInt(inT.substring(in_idx+1));
        		int inMins = in_h*60 + in_m;
        		System.out.println("inMins: "+ inMins);
        		
        		//출차시간
        		int oMins = (23*60) + 59;
        		System.out.println("oMins: "+ oMins);
        		
        		int p_time = oMins-inMins;//주차시간
        		map.put(in.get(i), p_time); //주차금액으로 변경 
        		
        		//당일 중복 출차시 총 주차시간 계산 
            	if(t_time.containsKey(in.get(i))){
            		int exTime=(Integer)t_time.get(in.get(i));
            		t_time.put(in.get(i), exTime+p_time);
            	}else {
            		t_time.put(in.get(i), p_time);
            	}
//        		System.out.println("total Min: "+ (oMins-inMins));
        		in.remove(in.get(i));
        	}
        }
        System.out.println("최종 남은 주차 차량: "+in);
        
        
        //t_time에 최종 주차시간으로 주차요금 계산
        for(Object c : t_time.keySet()){
        	int p_time =(Integer)t_time.get(c);
        	
        	//주차요금 = if (주차시간 >180){ 기본요금 + Ceil((주차시간-기본시간)/단위시간) *단위요금}
        	//주차요금 = else (기본요금)

        	int tFee;
        	if(p_time>180){
        		tFee = Gfee + (int) (Math.ceil((p_time-Gtime)/Dtime)*Dfee);
        	}else {
        		tFee = Gfee;
        	}
        	map.put(c, tFee); //주차금액으로 변경 
        }
        
        
        
        
        Object[] keys = map.keySet().toArray();
        Arrays.sort(keys);
        System.out.println("keys: "+ Arrays.toString(keys));
        List<Integer> arr = new ArrayList<>();
        for(Object s : map.keySet()){
        	int t=(Integer) map.get((String)s);
        	arr.add(t);
        }
        answer = arr.stream().mapToInt(i->i).toArray();
        return answer;
    }
    
    public static void main(String[] args) {
//    	Solution1 h = new Solution1();
		
		int[] p= {120, 0, 60, 591};
		String[] c = {"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"};
//		int[] p= {180, 5000, 10, 600};
//		String[] c = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		int k =3;

		System.out.println(solution(p, c));
	}
    
    
//	실행한 결괏값 [34400,14000,5000]이(가) 기댓값 [14600,34400,5000]와(과) 다릅니다.
    
    //[120, 0, 60, 591], ["16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"]
//    기댓값 〉	[0, 591]
}