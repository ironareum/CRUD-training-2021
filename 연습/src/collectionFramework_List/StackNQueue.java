package collectionFramework_List;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackNQueue {
	public static void main(String[] args) {
		Stack stack = new Stack();
		Queue queue = new LinkedList();
		
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");
		
		queue.offer("a");
		queue.offer("b");
		queue.offer("c");
		queue.offer("d");
		
		System.out.println("stack: "+stack);
		
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
		System.out.println("queue: "+queue);
		while(!queue.isEmpty()){
			System.out.println(queue.poll());
		}
		
	}
}
