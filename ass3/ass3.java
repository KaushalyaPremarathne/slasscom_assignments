//import static sun.security.util.Debug.args;

public class ass3 {

    public static void selectionSort(int[] numArray){



        int size = numArray.length;

        for (int i = 0; i < size - 1; i++)
        {
            int index = i;

            for (int j = i + 1; j < size; j++){
                if (numArray[j] < numArray[index]){
                    index = j;//searching for lowest index
                }
            }
            int smallerNumber = numArray[index];
            numArray[index] = numArray[i];
            numArray[i] = smallerNumber;
        }
    }

    public static void main(String args[]){
        int[] numArray = {47, 84, 75, 21, 14, 14, 79};

        int size = numArray.length;

        selectionSort(numArray);//sorting array using selection sort
        
        int maxCount = 0;
        int median = 0;
        int mode = 0;

        if(size % 2 == 0)
            median = (numArray[size/2] + numArray[(size/2)+1]) / 2;
        else
            median = numArray[size/2];

        System.out.println("Median : " + median);
        System.out.println("Highest Value : " + numArray[size-1]);

        for(int i = 0; i < size; i++){
            int count = 0;
            for(int j = 0; j < size; j++){
                if( numArray[i] == numArray[j])
                    count ++;
            }

            if (count > maxCount){
                maxCount = count;
                mode = numArray[i];
            }
        }

        System.out.println("Mode : " + mode);
    }
}
