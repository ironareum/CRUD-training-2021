package ThreadEx;

import java.io.ObjectInputStream.GetField;

public class ThreadEx1 {
	public static void main(String[] args) {
		ThreadEx1_1 t1 = new ThreadEx1_1();
		Runnable r = new ThreadEx1_2();
		Thread t2= new Thread(r);
		
//		t1.run();
//		t2.run();
		
		t1.start();
		t2.start();
		try {
			for(int i=0; i<5; i++){
				Thread.sleep(2000);
				System.out.println("sleep-t1?");
//				t2.sleep(3000);
//				System.out.println("sleep-t2?");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

class ThreadEx1_1 extends Thread{
	public void run(){
		try {
			for(int i=0; i<10; i++){
				Thread.sleep(1000);
				System.out.println(getName()+"-Ex1");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

class ThreadEx1_2 implements Runnable{
	@Override
	public void run() {
		try {
			for(int i=0; i<10; i++){
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName()+"-Ex2");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}