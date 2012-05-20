package org.wjhua.twquiz.domain2;

import java.util.Stack;

public class Queue<T> {

	private Stack<T> stack1 = new Stack<T>();

	private Stack<T> stack2 = new Stack<T>();

	public void dequeue() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				T data = stack1.peek();
				stack1.pop();
				stack2.push(data);
			}
		}

		// push the element into stack2
		stack2.pop();
	}

	public void enqueue(T item) {
		stack1.push(item);
	}
	
	public static void main(String[] args) {
//		Queue<String>
	}
}
