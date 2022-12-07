
public class romanToInt {

	public static void main(String[] args) {
		
		String s = "LIV";
		
		//assigning relative integers for the romans
		int  I = 1;
		int  V = 5;
		int  X = 10;
		int  L = 50;
		int  C = 100;
		int  D = 500;
		int  M = 1000;
		
		//store the string in a char array
		char arr[] = s.toCharArray();
		
		//integer array
		int valueArr[];
		valueArr = new int[15];
		
		int num = 0;
		
		/*
		 * assign integers to relevant characters
		 * according to the assignments of above
		 */
		for(int i = 0; i < s.length(); i++) {
			
			if(arr[i] == 'I')
				valueArr[i] = I;
			
			else if(arr[i] == 'V')
				valueArr[i] = V;
			
			else if(arr[i] == 'X')
				valueArr[i] = X;
			
			else if(arr[i] == 'L')
				valueArr[i] = L;
			
			else if(arr[i] == 'C')
				valueArr[i] = C;
			
			else if(arr[i] == 'D')
				valueArr[i] = D;
			
			else if(arr[i] == 'M')
				valueArr[i] = M;
			
			else
				System.out.println("Invalid character");
		}
		
		//calculate the integer value
		for(int j = 0; j < s.length(); j++) {
			
			//handle situations :"XXIV"
			if(valueArr[j] < valueArr[j+1]) {
				valueArr[j] = -valueArr[j];
			}	
			num = num + valueArr[j];
		}
		
		System.out.println(num);
	}
}
