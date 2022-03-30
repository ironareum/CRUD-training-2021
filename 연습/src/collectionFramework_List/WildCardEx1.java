package collectionFramework_List;

import java.util.ArrayList;

public class WildCardEx1 {
	public static void main(String[] args) {
		Box<Fruit> fruitBox = new Box<Fruit>();
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		
//		Box<Fruit> appleBox = new Box<Apple>(); //에러
		Box<Apple> appleBox = new FruitBox<Apple>();
		appleBox.add(new Apple());
//		appleBox.add((Apple) new Fruit());
		
		FruitBox<Fruit> fruitBox1 = new FruitBox<Fruit>();
		fruitBox1.add(new Fruit());
		fruitBox1.add(new Apple());
//		fruitBox1.add(new Toy());
		
		FruitBox<Apple> appleBox1 = new FruitBox<Apple>();
		appleBox1.add(new Apple());
//		appleBox1.add(new Grape());
//		FruitBox<Toy> toyBox = new FruitBox<Toy>();
		//========================================
		
		Juicer juicer = new Juicer();
		Juicer.makeJuice(fruitBox1);
		Juice appleJuice =Juicer.makeJuice(appleBox1);
		System.out.println(appleJuice);
	}
	
}

class Juicer{
	static Juice makeJuice(FruitBox<? extends Fruit> box){
		
		String tmp="";
		for(Fruit f : box.getList()) tmp+=f+" ";
		return new Juice(tmp);
		
	}
}

class Juice {
	String name;
	
	Juice(String name){ this.name= name +"Juice";}
	public String toString(){
		return this.name;
	}
}

class Fruit implements Eatable{
	
	public String toString(){return "Fruit";}
}

interface Eatable {}

class Apple extends Fruit{public String toString(){return "Apple";}}
class Grape extends Fruit{public String toString(){return "Grape";}}
class Toy {public String toString(){return "Toy";}}

class FruitBox<T extends Fruit & Eatable> extends Box<T>{
	public String toString(){return "FruitBox";}
}

class Box<T>{
	ArrayList<T> list = new ArrayList<T>();
	void add(T item){list.add(item);}
	T get(int i){return list.get(i);}
	ArrayList<T> getList(){ return list;}
	int size(){return list.size();}
	public String toString(){return "Box";}
}