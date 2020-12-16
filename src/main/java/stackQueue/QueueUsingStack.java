package stackQueue;

import java.util.Stack;

/*
 * This is an implementation of Queue using 2 stack
 * So that each operation takes constant number of amortized operation	
 */
public class QueueUsingStack<T> {

	Stack<T> current = new Stack<T>();
	Stack<T> helper = new Stack<T>();
	
	public void add(T item) {
		current.push(item);
	}
	
	public T poll() {
		swapStacks(current, helper);
		T top = helper.pop();
		swapStacks(helper, current);
		return top;
	}
	
	
	private void swapStacks(Stack<T> origin, Stack<T> destination) {
		while(!origin.empty()) {
			destination.add(origin.pop());
		}
	}
}
