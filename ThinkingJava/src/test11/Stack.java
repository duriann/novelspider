package test11;

import java.util.LinkedList;

public class Stack<T> {
	
	private LinkedList<T> list = new LinkedList<T>();
	
	public void push(T t){
		list.addFirst(t);
	}
	public T peek(){
		return list.getFirst();
	}
	public T pop(){
		return list.removeFirst();
	}
	public boolean isEmpty(){
		return list.isEmpty();
	}
	public String toString(){
		return list.toString();
	}
}
