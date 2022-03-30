package collectionFramework_List;

public class MyVector {

	Object[] data = null;
	int capacity =0;
	int size = 0;
	
	public MyVector(int capacity) {
		if(capacity <0){
			throw new IllegalArgumentException("유효하지 않은 값 입니다.");
		}
		this.capacity = capacity;
		
		data = new Object[capacity]; // Object 배열의 길이 capacity 값 으로 셋팅
	}
	
	public MyVector(){
		this(10); //int 매개변수로 갖는 생성자 하나 만들어 줘야됨 , 기본값 10                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
	}
	
	//최소한의 공간 확보하는 메서드 
	public void ensureCapacity(int minCapacity){
		if(minCapacity - data.length > 0){ //요청한 capacity가 현재 배열의 size 보다 커야됨
			System.out.println("setCapacity 시작");
			setCapacity(minCapacity);
			System.out.println("minCapacity ="+minCapacity);
		}
	}

	private void setCapacity(int capacity){ //capacity 새로 set 하고 
		if(this.capacity == capacity) return;
		
		Object[] tmp = new Object[size];
		System.arraycopy(data, 0, tmp, 0, size-1);
		this.data = tmp;
		this.capacity = capacity;
	}
	
	public boolean add(Object obj){
		//새로운 객체를 저장하기전 공간 확보
		System.out.println("add 요청. size ="+size);
		ensureCapacity(size+1);
		data[size++] = obj;
		System.out.println("add 후. size ="+size);
		return true;
	}
	
	
	
	public Object[] toArray(){
		Object[] result = new Object[size];
		System.arraycopy(data, 0, result, 0, size-1);
		return result;
	}
	
	public static void main(String[] args) {
		MyVector myVector = new MyVector(1);
		System.out.println(myVector.data.length);
		myVector.add("a");
		myVector.add("b");
		
		System.out.println(myVector.data.length);
		System.out.println(myVector.data[0]);
//		System.out.println(myVector.data[1]);
		
		System.out.println(myVector.toArray());
	}

}
