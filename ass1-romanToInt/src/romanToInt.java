
public class romanToInt {

	public static void main(String[] args) {
		
		String s = "XX";
		
		//assigning relative integers for the romans
		int  I = 1;
		int  V = 5;
		int  X = 10;
		int  L = 50;
		int  C = 100;
		int  D = 500;
		int  M = 1000;
		
		int count_i = 0;
		int count_v = 0;
		int count_x = 0;
		int count_l = 0;
		int count_c = 0;
		int count_d = 0;
		int count_m = 0;
		
		//store the string in a char array
		char arr[] = s.toCharArray();
		
		//calculate the interger value
		for(int i = 0; i < s.length(); i++) {
			
			if(arr[i] == 'I')
				count_i++ ;
			
			else if(arr[i] == 'V')
				count_v++;
			
			else if(arr[i] == 'X')
				count_x++;
			
			else if(arr[i] == 'L')
				count_l++;
			
			else if(arr[i] == 'C')
				count_c++;
			
			else if(arr[i] == 'D')
				count_d++;
			
			else if(arr[i] == 'M')
				count_m++;
			
			else
				System.out.println("Invalid character");
		}
		
		int num = count_i + count_v * V + count_x * X + count_l * L + count_c * C + count_d * D + count_m * M;
		
		System.out.println(num);
	}
}
