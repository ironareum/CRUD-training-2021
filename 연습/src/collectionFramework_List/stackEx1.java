package collectionFramework_List;

import java.util.*;

public class stackEx1 {
	public static Stack back = new Stack();
	public static Stack forward = new Stack();
	
	public static void main(String[] args) {
		goURL("1.네이트");
		goURL("2.야후");
		goURL("3.네이버");
		goURL("4.다음");
		
		printStatus();
		
		goBack();
		System.out.println("뒤로 가기 버튼 누른 후 ==");
		printStatus();
		
		goForward();
		System.out.println("앞으로 가기 버튼 누른 후 ==");
		printStatus();
		
		goURL("새로운 주소: 라이코스!");
		printStatus();
		
	}
	
	@SuppressWarnings("unchecked")
	public static void goURL(String url){
		back.push(url);
		if(!forward.isEmpty())
			forward.clear();
	}
	
	public static void goBack(){
		forward.push(back.pop());
	}
	
	public static void goForward(){
		back.push(forward.pop());
	}
	
	
	public static void printStatus(){
		System.out.println("back : "+ back);
		System.out.println("forward : "+ forward);
		System.out.println("currunt page is \""+ back.peek()+"\" .");
		System.out.println();
	}
	
	
	
}
