package FindingNearestNPlaces;

import java.util.Random;
import java.util.Scanner;


public class RadixSortAlgorithm {
	public static void RadixSort() {									//Sorting an array which is unsorted with Radix Sort Algorithm
		int n;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of inputs: ");
		n = input.nextInt();											//Taking the number of inputs from keyboard
		Random r = new Random();
		int[] numberArray = new int[n];
		for(int i=0; i<n; i++){
			numberArray[i] = r.nextInt(n);								//Creating an array that contains n random integers in the range (0, n)
		}
		Stopwatch stopwatch = new Stopwatch();
		numberArray = radixSort(numberArray, n);						//Calling the 'radixSort' method with array and its size
		double time = stopwatch.elapsedTime();							//Measuring the runtime for the number of inputs
		System.out.println(time);
	}
	public static int[] radixSort(int[] A, int d){
		int digitPlace = 1;
		int result[] = new int[d];
		int largestNumber = getMax(A);
		while((largestNumber/digitPlace)>0){							//In this algorithm the code sorting the array with respect to 
			int[] count = new int[10];									//their value of each digit
			for(int i=0; i<10; i++){
				count[i] = 0;
			}
			for(int i=0; i<d; i++){
				count[(A[i]/digitPlace)%10]++;
			}
			for(int i=1; i<10; i++){
				count[i] += count[i-1];
			}
			for(int i=d-1; i>=0; i--){
				result[count[(A[i]/digitPlace)%10]-1] = A[i];
				count[(A[i]/digitPlace)%10]--;
			}
			for(int i=0; i<d; i++){
				A[i] = result[i];
			}
			digitPlace = digitPlace * 10;
		}
		return result;
		
	}
	public static int getMax(int A[])									//Getting the maximum element in the array
    {
        int max = A[0];
        for (int i = 1; i < A.length; i++){
            if (A[i] > max)
                max = A[i];
        }
        return max;
    }

}
