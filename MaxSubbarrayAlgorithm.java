package FindingNearestNPlaces;

import java.util.Random;
import java.util.Scanner;


public class MaxSubbarrayAlgorithm {
	public static void MaxSub() {											//Finding the maximum subarray sum that its element's sum is greater in other subarrays
		int n, max_sum;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of inputs: ");
		n = input.nextInt();												//Taking the number of inputs from keyboard
		Random r = new Random();
		int[] numberArray = new int[n];
		for(int i=0; i<n; i++){
			numberArray[i] = r.nextInt(n);									//Creating an array that contains n random integers in the range (0, n)
		}
		Stopwatch stopwatch = new Stopwatch();
		max_sum = maxSub(numberArray, 0, (n-1));							//Calling the 'maxSub' method with array and its begin and end indices
		double time = stopwatch.elapsedTime();								//Measuring the runtime for the given number of inputs
		System.out.println(time);

	}
	
	public static int maxCrossingSum(int[] A, int l, int m, int h){
		int sum = 0;
		int leftsum = Integer.MIN_VALUE;
		for(int i=m; i>=0; i--){
			sum = sum + A[i];
			if(sum>leftsum){
				leftsum = sum;
			}
		}
		sum = 0;
		int rightsum = Integer.MIN_VALUE;
		for(int i=(m+1); i<h; i++){
			sum = sum + A[i];
			if(sum>rightsum){
				rightsum = sum;
			}
		}
		return (leftsum+rightsum);
	}
	public static int maxSub(int[] A, int lo, int hi){
		if(lo==hi){
			return A[lo];
		}
		int m = (lo+hi)/2;
		return max(maxSub(A, lo, m), maxSub(A, m+1, hi), maxCrossingSum(A, lo, m, hi));
	}
	public static int max(int a, int b){
		return (a>b)? a:b;
		}
	public static int max(int a, int b, int c){
		return max(max(a,b),c);
	}

}
