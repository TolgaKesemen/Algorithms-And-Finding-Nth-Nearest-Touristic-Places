package FindingNearestNPlaces;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class main {
	/*We analyzed given algorithms and measured their runtime in Part1.
	 * Also in this assignment we are expected to implement a code such
	 * that finds the N nearest touristic places for a person with
	 * respect to distance and fee for Part2*/

	public static void main(String[] args) {
		/*If you want to run Part1
		 * you should changed the code lines below from comment
		 * and change other code lines to comment.
		 */

//		SecondElement sc = new SecondElement();
//		sc.SecondEl();
//		StoogeSortAlgorithm ssa = new StoogeSortAlgorithm();
//		ssa.StoogeSort();
//		RadixSortAlgorithm ra = new RadixSortAlgorithm();
//		ra.RadixSort();
//		ShakerSortAlgorithm ss = new ShakerSortAlgorithm();
//		ss.ShakerSort();
//		MaxSubbarrayAlgorithm ms = new MaxSubbarrayAlgorithm();
//		ms.MaxSub();


		int N, n, a, b, count=1;
		boolean condition = false;									//condition variable is used for control to is there any touristic place nearby
		Scanner input = new Scanner(System.in);
		System.out.print("N: ");
		System.out.println();
		N = input.nextInt();
		n = N;
		int r = ThreadLocalRandom.current().nextInt(-1000, 1000);		//Generating our person's coordinates -> (a, b)
		a = r;
		r = ThreadLocalRandom.current().nextInt(-1000, 1000);
		b = r;
		ArrayList<Place> place = new ArrayList<Place>();				//Creating an arraylist to keep place objects.
		for(int i=0; i<100; i++){
			/*In this for loop, an object 'tmp' is created and
			 * its coordinates (x, y), its fee calculated randomly.
			 * Its generating index and distance from our person
			 * is defined and set.*/
			Place tmp = new Place();
			r = ThreadLocalRandom.current().nextInt(-1000, 1001);
			tmp.setX(r);
			r = ThreadLocalRandom.current().nextInt(-1000, 1001);
			tmp.setY(r);
			r = ThreadLocalRandom.current().nextInt(0, 61);
			tmp.setFee(r);
			tmp.setIndex(i);
			tmp.setDistance((int)Math.sqrt((Math.pow((a-tmp.getX()), 2) + (Math.pow((b-tmp.getY()), 2)))));
			place.add(tmp);
		}
		place = sort(place);										//The array which keep place objects is sent for sorting to sort() function
		for(int l = 0; l<100; l++){
			//This for loop checks there is at least one place nearby to show.
			//If there is none then the condition variable stays as false.
			if((place.get(l).getDistance()<=200)&&(-200<=place.get(l).getDistance())&&(N>0)){
				System.out.println("The booster distances are found!");
				condition = true;
				break;
			}
		}
		if(!condition){
			//Program prints an error message for user that there isn't any touristic places found
			System.out.println("There isn't any touristic places nearby!!!");
		}

		for(int i= 0; i<100; i++){
			//This for loop prints the N touristic places
			//N has taken as input
			if((place.get(i).getDistance()<=200)&&(-200<=place.get(i).getDistance())&&(N>0)){
				System.out.println(count+"th nearest distance calculated with the "+place.get(i).getIndex()+"th generated coordinate is "+place.get(i).getDistance());
				System.out.println("Coordinates of touristic place is ("+place.get(i).getX()+","+place.get(i).getY()+"), location fee is "+place.get(i).getFee());
				System.out.println();
				count++;
				N--;
			}
		}
		if((count < n)&&condition){
//			If there isn't N places program prints how much is there
			System.out.println("There is only "+(count-1)+" touristic places nearby!!!");
		}
	}

	public static ArrayList<Place> sort(ArrayList<Place> place){
		int n = 99;
		for(int k=(n/2); k>=0; k--){								//Building max-heap using bottom-up method
			place = sink(place, k, n);
		}
		while(n>0){
			place = exch(place, 0, n);								//Repeatedly places the largest element to the end of the array
			place = sink(place, 0, (n-1));
			n--;
		}
		return place;

	}

	public static ArrayList<Place> sink(ArrayList<Place> place, int k, int n){			/*Finds the correct place for array element*/
		while((2*k)<n){
			int j = 2*k;
			if((j<n) && less(place, j, (j+1))){
				j++;
			}
			if(!less(place, k, j)){
				break;
			}
			place = exch(place, k, j);
			k = j;
		}
		return place;

	}

	public static boolean less(ArrayList<Place> place, int i, int j){			//Checking which element is larger
		return place.get(i).compareTo(place.get(j))<0;
	}

	public static ArrayList<Place> exch(ArrayList<Place> place, int i, int j){
		Place tmp = new Place();													//Exchanged elements for place them to correct position
		tmp = place.get(i);
		place.set(i, place.get(j));
		place.set(j, tmp);
		return place;
	}

}
