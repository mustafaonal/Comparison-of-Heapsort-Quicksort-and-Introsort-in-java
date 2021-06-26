package assigment1;

public class SortingClass {

	// ---------------------------heap sort----------------
	public void heapSort(int[] arrayToSort) {
		int n = arrayToSort.length;
		buildMaxHeap(arrayToSort, n);
		for (int i = n - 1; i >= 0; i--) {
			int temp = arrayToSort[0];
			arrayToSort[0] = arrayToSort[i];
			arrayToSort[i] = temp;
			maxHeap(arrayToSort, i, 0);
		}
	}

	public void buildMaxHeap(int[] A, int n) {
		for (int i = n / 2 - 1; i >= 0; i--)
			maxHeap(A, n, i);
	}

	public void maxHeap(int[] A, int n, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && A[left] > A[largest])
			largest = left;
		else
			largest = i;

		if (right < n && A[right] > A[largest])
			largest = right;

		if (largest != i) {
			int temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;
			maxHeap(A, n, largest);
		}

	}

	// ---------------------------heap sort-----------------

	public void printArray(int A[]) {
		int n = A.length;
		for (int i = 0; i < n; i++)
			System.out.println(A[i] /* + "  " */);
		System.out.println();
	}

	public static void swap(int[] A, int firstIndex, int secondIndex) {
		int temp = A[firstIndex];
		A[firstIndex] = A[secondIndex];
		A[secondIndex] = temp;
	}

	// --------------------------quick sort-----------------

	public void quickSort(int[] arrayToSort, String pivotType) {
		int n = arrayToSort.length;
		if (pivotType.equalsIgnoreCase("FirstElement")) {
			quickSortFirstElement(arrayToSort, 0, n - 1);
		} else if (pivotType.equalsIgnoreCase("RandomElement")) {
			quickSortRandomElement(arrayToSort, 0, arrayToSort.length - 1);
		} else if (pivotType.equalsIgnoreCase("MidOfFirstMidLastElement")) {
			MidOfFirstMidLastElement(arrayToSort, 0, arrayToSort.length - 1);
		} else if (pivotType.equalsIgnoreCase("dualPivotQuickSort")) {
			dualQsort(arrayToSort, 0, arrayToSort.length - 1);
		} else
			System.out.println("this pivot type is no exist.");

	}

	public int partition(int A[], int firstElement, int lastElement) { // general partition
		int pivot = A[lastElement];
		int indexOfSmaller = (firstElement - 1);

		for (int i = firstElement; i < lastElement; i++) {
			if (A[i] <= pivot) {
				indexOfSmaller++;
				int temp = A[indexOfSmaller];
				A[indexOfSmaller] = A[i];
				A[i] = temp;
			}
		}
		int temp = A[indexOfSmaller + 1];
		A[indexOfSmaller + 1] = A[lastElement];
		A[lastElement] = temp;

		return indexOfSmaller + 1;
	}

	// -------------First Element-----------------
	public void quickSortFirstElement(int A[], int firstElement, int lastElement) {
		if (firstElement < lastElement) {
			int pivot = partitionFirst(A, firstElement, lastElement);
			quickSortFirstElement(A, firstElement, pivot - 1);
			quickSortFirstElement(A, pivot + 1, lastElement);
		}

	}

	public int partitionFirst(int[] A, int lastElement, int firstElement) {
		// swap(A, lastElement, firstElement);
		int temp = A[lastElement];
		A[lastElement] = A[firstElement];
		A[firstElement] = temp;

		int pivot = A[lastElement];
		int indexOfSmaller = (firstElement - 1);

		for (int i = firstElement; i < lastElement; i++) {
			if (A[i] <= pivot) {
				indexOfSmaller++;
				// swap(A, indexOfSmaller, i);
				int temp2 = A[indexOfSmaller];
				A[indexOfSmaller] = A[i];
				A[i] = temp2;
			}
		}
		// swap(A, indexOfSmaller + 1, lastElement);
		int temp2 = A[indexOfSmaller + 1];
		A[indexOfSmaller + 1] = A[lastElement];
		A[lastElement] = temp2;

		return indexOfSmaller + 1;
	}

	// -------------Random Element-----------------

	public void quickSortRandomElement(int A[], int firstElement, int lastElement) {
		if (firstElement < lastElement) {
			int pivot = partitionRandom(A, firstElement, lastElement);
			quickSortRandomElement(A, firstElement, pivot - 1);
			quickSortRandomElement(A, pivot + 1, lastElement);
		}
	}

	public int partitionRandom(int A[], int firstElement, int lastElement) {
		int randomIndex = (int) Math.floor(Math.random() * (lastElement - firstElement + 1) + firstElement);
		int temp = A[lastElement];
		A[lastElement] = A[randomIndex];
		A[randomIndex] = temp;
		int pivot = A[lastElement];
		int indexOfSmaller = (firstElement - 1);

		for (int i = firstElement; i < lastElement; i++) {
			if (A[i] <= pivot) {
				indexOfSmaller++;
				swap(A, indexOfSmaller, i);
				int temp2 = A[indexOfSmaller];
				A[indexOfSmaller] = A[i];
				A[i] = temp2;
			}
		}
		int temp2 = A[indexOfSmaller + 1];
		A[indexOfSmaller + 1] = A[lastElement];
		A[lastElement] = temp2;

		return indexOfSmaller + 1;
	}

	// -------------MidOfFirstMidLast Element-----------------

	public void MidOfFirstMidLastElement(int[] A, int firstElement, int lastElement) {
		if (firstElement < lastElement) {
			int pivot = partitionMid(A, firstElement, lastElement);
			MidOfFirstMidLastElement(A, firstElement, pivot - 1);
			MidOfFirstMidLastElement(A, pivot + 1, lastElement);

		}

	}

	public int partitionMid(int[] A, int firstElement, int lastElement) {
		int middle = (lastElement - firstElement) / 2;
		if (A[firstElement] >= A[lastElement] && A[firstElement] <= A[middle]
				|| A[firstElement] <= A[lastElement] && A[firstElement] >= A[middle]) {
			int temp = A[lastElement];
			A[lastElement] = A[firstElement];
			A[firstElement] = temp;
		} else if (A[middle] >= A[firstElement] && A[middle] <= A[lastElement]
				|| A[middle] <= A[firstElement] && A[middle] >= A[lastElement]) {
			int temp = A[lastElement];
			A[lastElement] = A[middle];
			A[middle] = temp;
		}

		int pivot = A[lastElement];
		int indexOfSmaller = (firstElement - 1);

		for (int i = firstElement; i < lastElement; i++) {
			if (A[i] <= pivot) {
				indexOfSmaller++;
				int temp = A[indexOfSmaller];
				A[indexOfSmaller] = A[i];
				A[i] = temp;
			}
		}
		int temp = A[indexOfSmaller + 1];
		A[indexOfSmaller + 1] = A[lastElement];
		A[lastElement] = temp;

		return indexOfSmaller + 1;

	}

	// -------------DualPivot Element-----------------

	public void dualQsort(int[] A, int left, int right) {
		if (right - left >= 1) {
			if (A[left] > A[right]) {
				swap(A, left, right);
			}
			final int p = A[left];
			final int q = A[right];
			int l = left + 1, g = right - 1, k = l;
			while (k <= g) {
				if (A[k] < p) {
					swap(A, k, l);
					++l;
				} else if (A[k] >= q) {
					while (A[g] > q && k < g)
						--g;
					{
						swap(A, k, g);
					}
					--g;
					if (A[k] < p) {
						swap(A, k, l);
						++l;
					}
				}
				++k;
			}
			--l;
			++g;
			{
				swap(A, left, l);
			}
			{
				swap(A, right, g);
			}
			dualQsort(A, left, l - 1);
			dualQsort(A, l + 1, g - 1);
			dualQsort(A, g + 1, right);
		}
	}

	// --------------------------quick sort-----------------

	public void sort(int[] A, int firstElement, int lastElement) {
		int maxDepth = (int) (Math.log(A.length) * 2);
		introSort(A, firstElement, lastElement, maxDepth);
	}

	public void introSort(int[] A, int firstElement, int lastElement, int maxDepth) {
		int n = A.length;

		if (n <= 1)
			return;
		else if (maxDepth == 0)
			heapSort(A);
		else {
			if (firstElement >= lastElement)
				return;

			int q = partition(A, firstElement, lastElement);
			introSort(A, firstElement, q - 1, maxDepth - 1);
			introSort(A, q + 1, lastElement, maxDepth - 1);

		}

	}
}
