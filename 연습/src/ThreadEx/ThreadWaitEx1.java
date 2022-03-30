package ThreadEx;

import java.util.ArrayList;

public class ThreadWaitEx1 {
	public static void main(String[] args) throws InterruptedException {
		Table table = new Table();
		
		new Thread(new Cook(table), "COOK1").start();
		new Thread(new Customer(table, "donut"), "CUST1").start();
		new Thread(new Customer(table, "burger"), "CUST2").start();
		
		Thread.sleep(5000);
		System.exit(0);
	}
}

class Customer implements Runnable{
	private Table table;
	private String food;
	
	Customer(Table table, String food){
		this.table = table;
		this.food = food;
	}

	@Override
	public void run() {
		while(true){			
			try {
				Thread.sleep(10);
			} catch (Exception e) {
			}
			String name = Thread.currentThread().getName();
			table.remove(food);
			System.out.println(name + " ate a " + food);
			
		}
	}

}

class Cook implements Runnable{
	private Table table;
	
	Cook(Table table){this.table = table;}
	
	@Override
	public void run() {
		while(true){
			//임의의 요리를 하나 선택해서 table에 추가한다.
			int idx =(int)(Math.random()*table.dishNum());
			table.add(table.dishNames[idx]);
			try {
				Thread.sleep(10);
			} catch (Exception e) {}
		}
	}
}

class Table {
	String[] dishNames ={"donut", "donut", "burger"};
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<String>();
	
	public synchronized void add (String dish){
		while(dishes.size()>= MAX_FOOD){
			String name = Thread.currentThread().getName();
			System.out.println(name + " is waiting for next round. ("+dish+")");
			try {
				wait(); //Cook 쓰레드를 기다리게. 
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		dishes.add(dish);
		notify(); //기다리고 있는 CUST 깨우기
		System.out.println("Dishes : "+ dishes.toString());
	}
	
	public void remove(String dish){
		synchronized (this) {			
			String name = Thread.currentThread().getName();
			while(dishes.size()==0){
				System.out.println("[empty]"+name +" is waiting....");
				try {
					wait(); //CUST 기다리게 함
					Thread.sleep(500);
				} catch (Exception e) {}
			}
			
			while(true){				
				for(int i=0; i<dishes.size(); i++){
					if(dish.equals(dishes.get(i))){
						dishes.remove(i);
						notify(); //COOK 깨우기 
						return;
					}
				}
				try {
					System.out.println("[not exist]"+name +" is waiting...for "+ dish);
					wait();
					Thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
	public int dishNum() {return dishNames.length;}
}