import javax.imageio.stream.ImageInputStream;

//import static sun.security.util.Debug.args;

public class insertionSort {

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

        int count = 0;
        int median, mode = 0;

        for(int i:numArray){
            count++;
        }

        if(count % 2 == 0)
            median = (numArray[count/2] + numArray[(count/2)+1]) / 2;
        else
            median = numArray[count/2];

        System.out.println("Median : " + median);
        System.out.println("Highest Value : " + numArray[size-1]);

        
    }
}
