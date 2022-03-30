package ThreadEx;

public class ThreadEx21_synchronized {
	public static void main(String[] args) {
		RunnableEx21 r= new RunnableEx21();
		Thread t1= new Thread(r);
		Thread t2= new Thread(r);
		t1.start();
		t2.start();
	}
}

class Account {
	private int balance =1000; //공동계좌 
	
	public  void withdraw(int money){
		synchronized (this) {
			System.out.println(Thread.currentThread().getName()+" - "+ money);
			if(balance >= money){
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				balance-=money;
			}	
		}
	}
	
	public int getBalance(){
		return this.balance;
	}
}

class RunnableEx21 implements Runnable {
	Account acc = new Account();
	public void run() {
		String name = Thread.currentThread().getName();
		while(acc.getBalance()>0){
			int money=(int)(Math.random()*3+1)*100;
			
			acc.withdraw(money);
			System.out.println(name+" -balance : "+acc.getBalance());		
		}
	}
}