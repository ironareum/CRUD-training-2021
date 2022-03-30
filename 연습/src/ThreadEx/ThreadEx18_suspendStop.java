package ThreadEx;

public class ThreadEx18_suspendStop {
	public static void main(String[] args) {
		RunImplEx18 th1 =new RunImplEx18("*");
		RunImplEx18 th2 =new RunImplEx18("**");
		RunImplEx18 th3 =new RunImplEx18("***");
		th1.start();
		th2.start();
		th3.start();
		
		try {
			Thread.sleep(2000);
			th1.suspend();
			Thread.sleep(2000);
			th2.suspend();
			Thread.sleep(3000);
			th1.resume();
			Thread.sleep(3000);
			th1.stop();
			th2.stop();
			Thread.sleep(2000);
			th3.stop();
			
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName()+" -sleep");
		}
	}
}

class RunImplEx18 implements Runnable {
	
	volatile boolean suspended =false;
	volatile boolean stoped =false;
	Thread th;
	
	RunImplEx18(String name){
		th = new Thread(this, name); //Thread(Runnable r, String name)
	}
	
	@Override
	public void run() {
		String name = th.getName();
		while(!stoped){
			if(!suspended){
				System.out.println(name);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(name +"-interrupted");
				}
			}else {
				Thread.yield();
			}
		}
		System.out.println(name+ "- stopped");
	}
	
	public void suspend(){
		suspended =true;
		th.interrupt();
		System.out.println(th.getName() +"- interrupt() by suspend()");
	}
	public void resume(){
		suspended =false;
		}
	public void stop(){
		stoped =true;
		th.interrupt();
		System.out.println(th.getName() +"- interrupt() by stop()");
		}
	public void start() {th.start();}

	
}
