package ass2;

import java.util.Scanner;

public class assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter String : ");
		String str = scanner.nextLine();
		
		//convert the string to a char array
		char arr[] = str.toCharArray();
		
		String open = "({[";
		String close = ")}]";
		
		int size = arr.length;
		
		Stack newStack = new Stack(size);
		
		//check characters
		if(size == 0) 
			System.out.println("Null value");
		else {
			for( int i = 0; i < size; i++) {
				if (arr[i] == '{' || arr[i] == '[' || arr[i] == '(') {
					newStack.push(arr[i]);
				}
				else if (arr[i] == '}' || arr[i] == ']' || arr[i] == ')') {
					int j = close.indexOf(arr[i]);
					if (newStack.pop() == open.charAt(j)) {
						int n = 1;
					}
					else {
						System.out.println("Invalid Statement");
						break;
					}
				}
			}
			
			
			//validation
			if(newStack.isEmpty())
				System.out.println("Valid");
			else
				System.out.println("Invalid");
			
		}
		
	}

}
