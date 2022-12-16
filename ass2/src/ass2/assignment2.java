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
		
		int size = arr.length;
		
		//create stacks base on bracket type
		Stack curlyBracket = new Stack(size);
		Stack squareBracket = new Stack(size);
		Stack roundedBracket = new Stack(size);
		
		//check characters
		if(size == 0) 
			System.out.println("Null value");
		else {
			for(int i = 0; i < size; i++) {
				if(arr[i] == '(')
					roundedBracket.push(arr[i]);
				else if(arr[i] == ')')
					roundedBracket.pop();
				else if(arr[i] == '{')
					curlyBracket.push(arr[i]);
				else if(arr[i] == '}')
					curlyBracket.pop();
				if(arr[i] == '[')
					squareBracket.push(arr[i]);
				else if(arr[i] == ']')
					squareBracket.pop();
			}
			
			//validation
			if(curlyBracket.isEmpty() && roundedBracket.isEmpty() && squareBracket.isEmpty())
				System.out.println("Valid Statement");
			else
				System.out.println("Invalid");
		}
		
		
		
		
	}

}
