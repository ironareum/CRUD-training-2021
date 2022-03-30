package 알고리즘1;

public class 이중포문 {
	public static void main(String[] args) {
		
		for(int i=0; i<6; i++){// 0~5
			for(int j=6; j>i+1; j--){
				//6~2
				//6~3
				//6~4
				System.out.print(j);
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("=====");
		
		for(int i=0; i<=5; i++){
			for(int j=5; j>i; j--){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
