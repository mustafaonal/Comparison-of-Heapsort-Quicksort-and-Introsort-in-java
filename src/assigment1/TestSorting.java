package assigment1;

import java.util.Random;

public class TestSorting {

	public static void main(String[] args) {
		int n = 100000;
		int arr[] = new int[n];
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			arr[i] = 56;
			// arr[i] = rand.nextInt(10000);
			// arr[i] = n - i;
			// arr[i] = i;
		}
		// int[] arr = { 13, 19, 9, 5, 12, 8, 7, 4, 21, 2, 6, 11 };

		SortingClass ob = new SortingClass();
		// ob.dualQsort(arr, 0, arr.length - 1);
		// ob.heapSort(arr);
		// ob.dualQsort(arr, 0, arr.length - 1);
		// ob.quickSortRandomElement(arr, 0, arr.length - 1);
		// ob.sort(arr, 0, arr.length - 1);
		// ob.MidOfFirstMidLastElement(arr, 0, arr.length - 1);
		// ob.quickSortFirstElement(arr, 0, arr.length - 1);

		long startTime = System.nanoTime();
		ob.quickSort(arr, "dualPivotQuickSort");
		long totalTime = System.nanoTime() - startTime;

		double durationonMs = Math.pow(10, -6) * totalTime;
		System.out.println(durationonMs);
		System.out.println(totalTime);
		// ob.printArray(arr);
		System.out.println("length of array: " + arr.length);

	}

}
