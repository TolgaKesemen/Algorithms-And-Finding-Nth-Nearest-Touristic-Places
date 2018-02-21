package FindingNearestNPlaces;

import java.util.Random;
import java.util.Scanner;


public class SecondElement {
	public static void SecondEl() {									//Finding the largest element in an unsorted array
		int n, second;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of inputs: ");
		n = input.nextInt();										//Taking the number of inputs from keyboard
		Random r = new Random();
		int[] numberArray = new int[n];
		for(int i=0; i<n; i++){										//Creating an array that contains n random integers in the range (0, n)
			numberArray[i] = r.nextInt(n);
		}
		Stopwatch stopwatch = new Stopwatch();
		second = second(numberArray, n);							//Calling the 'second' method with array and its size
		double time = stopwatch.elapsedTime();						//Measuring the runtime for the number of inputs
		System.out.println(time);

	}
	public static int second(int[] A, int n){
		int max1=0, max2=0, tmp=0;
		if(A[0]<A[1]){												//Keeping the largest and second largest element both
			max1=A[1];												//Looking first two element to which one is greater
			max2=A[0];
		}
		else{
			max1=A[0];
			max2=A[1];
		}
		for(int i=2; i<n; i++){										//Comparing all elements with initial max1 and max2
			if(A[i]>max1){
				tmp=max1;
				max1=A[i];
				max2=max1;
			}
			else if((A[i]<max1)&&(A[i]>max2)){
				max2=A[i];
			}
		}
		return max2;												//Returning the second largest element
	}
}
