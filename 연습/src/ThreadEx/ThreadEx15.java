package ThreadEx;

public class ThreadEx15 {
	public static void main(String[] args) {
		RunImplEx15 r= new RunImplEx15();
		RunImplEx15 r1= new RunImplEx15();
		RunImplEx15 r2= new RunImplEx15();
		RunImplEx15 r3= new RunImplEx15();
		Thread th1 = new Thread(r1,"*");
		Thread th2 = new Thread(r2,"**");
		Thread th3 = new Thread(r3,"***");
		th1.start();
		th2.start();
		th3.start();
		
		try {
			Thread.sleep(2000);
			System.out.println("====");
//			th1.suspend();
//			Thread.sleep(2000);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

class RunImplEx15 implements Runnable{

	@Override
	public void run() {
		while(true){
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
}