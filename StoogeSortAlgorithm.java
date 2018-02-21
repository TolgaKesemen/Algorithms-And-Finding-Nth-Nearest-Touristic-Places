package FindingNearestNPlaces;

import java.util.Random;
import java.util.Scanner;


public class StoogeSortAlgorithm {
	public static void StoogeSort() {										//Sorting an array which is unsorted with Stooge Sort Algorithm
		int n;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of inputs: ");					
		n = input.nextInt();												//Taking the number of inputs from keyboard
		Random r = new Random();
		int[] numberArray = new int[n];
		for(int i=0; i<n; i++){												//Creating an array that contains n random integers in the range (0, n)
			numberArray[i] = r.nextInt(n);
		}
		Stopwatch stopwatch = new Stopwatch();
		numberArray = stoogeSort(numberArray, 0, (n-1));					//Calling the 'stoogeSort' method with array and its begin and end indices
		double time = stopwatch.elapsedTime();								//Measuring the runtime for the number of inputs
		System.out.println(time);
	}
	
	public static int[] stoogeSort(int[] L, int i, int j){					//Sorting the given array by calling itself recursively
		int temp;
		if(L[j]<L[i]){
			temp = L[j];													//Changing element's places with respect to which one is greater
			L[j] = L[i];
			L[i] = temp;
		}
		if((j-i)>1){
			temp = (j-i+1)/3;
			stoogeSort(L, i, (j-temp));										//Partitioning the array three parts and doing same processes all over again for them too
			stoogeSort(L, (i+temp), j);
			stoogeSort(L, i, (j-temp));
		}
		return L;
	}

}
