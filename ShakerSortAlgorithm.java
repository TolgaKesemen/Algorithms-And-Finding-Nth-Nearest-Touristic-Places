package FindingNearestNPlaces;

import java.util.Random;
import java.util.Scanner;


public class ShakerSortAlgorithm {
	public static void ShakerSort() {										//Sorting an array which is unsorted with Shaker Sort Algorithm
		int n;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of inputs: ");
		n = input.nextInt();												//Taking the number of inputs from keyboard
		Random r = new Random();
		int[] numberArray = new int[n];
		for(int i=0; i<n; i++){
			numberArray[i] = r.nextInt(n);									//Creating an array that contains n random integers in the range (0, n)
		}
		Stopwatch stopwatch = new Stopwatch();
		numberArray = shakerSort(numberArray, n);							//Calling the 'shakerSort' method with array and its size
		double time = stopwatch.elapsedTime();								//Measuring the runtime for the number of inputs
		System.out.println(time);
	}
	
	public static int[] shakerSort(int[] A, int n){
		boolean swapped;
		do{
			swapped = false;
			for(int i=0; i<(n-2); i++){										//Looking array elements from begin to end
				if(A[i]>A[i+1]){											//Changing their order if left element is bigger then right one
					int tmp;
					tmp = A[i];
					A[i] = A[i+1];
					A[i+1] = tmp;					
					swapped = true;
				}
			}
			if(swapped==false){												//If there is no change in  the array then it is sorted and close loop
				break;
			}
			swapped = false;
			for(int i=(n-2); i>=0; i--){									//Looking array elements from end to begin
				if(A[i]>A[i+1]){											//Changing their order if left element is bigger then right one
					int tmp;
					tmp = A[i];
					A[i] = A[i+1];
					A[i+1] = tmp;					
					swapped = true;
				}
			}
		}while(swapped);													//do-while continues until there is no swap 
		return A;															//returning the sorted array
	}

}
