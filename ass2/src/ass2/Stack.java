package ass2;

public class Stack {

	private int top;
	private int maxSize;
	private char stackArray[];
	
	public Stack(int j) {
		maxSize = j;
		top = -1;
		stackArray = new char[maxSize];
	}
	
	//isEmpty
	public boolean isEmpty() {
		if(top == -1)
			return true;
		else
			return false;
	}
	
	//isFull
	public boolean isFull() {
		if(maxSize - 1 == top)
			return true;
		else
			return false;
	}
	
	//push --> insert
	public void push(char s) {
		if(!isFull()) {
			top++;
			stackArray[top] = s;
		}
		else
			System.out.println("The stack is full");
	}
	
	//pop --> remove
	public char pop() {
		if(!isEmpty()) 
			return stackArray[top];
		else
			System.out.println("The stack is empty");
			return (char)-99;
	}
}
