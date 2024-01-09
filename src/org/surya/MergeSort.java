package org.surya;

public class MergeSort {

	static int[] sortedArr;
	public static void main(String[] args) {

		int arr[] = new int[] { 4,5,3,4,8,7,5,2 };
		arr = mergeSort(arr);
		for (int ele : arr) {
			System.out.println(ele);
		}
	}

	public static int[] mergeSort(int[] arr) {
		sortedArr = arr;
		split(0, sortedArr.length - 1);
		return sortedArr;
	}

	public static void split(int start, int end) {
		if (start < end) {

			// Find the middle point
			int mid = start + (end - start) / 2;

			// Sort first and second halves
			split(start, mid);
			split(mid + 1, end);

			// Merge the sorted halves
			sort(start, mid, mid + 1, end);
		}
	}

	public static void sort(int lStart, int lEnd, int rStart, int rEnd) {

		// If the direct merge is already sorted
		if (sortedArr[lEnd] <= sortedArr[rStart]) {	//Sorting  45 34  value =3   4554 5544 3454
			return;
		}

		// Two pointers to maintain start
		// of both arrays to merge
		while (lStart <= lEnd && rStart <= rEnd) {	//Iterating

			// If element 1 is in right place
			if (sortedArr[lStart] <= sortedArr[rStart]) {
				lStart++;
			} else {
				int value = sortedArr[rStart];
				int index = rStart;

				// Shift all the elements between element 1
				// element 2, right by 1.
				while (index != lStart) {
					sortedArr[index] = sortedArr[index - 1];
					index--;
				}
				sortedArr[lStart] = value;

				// Update all the pointers
				lStart++;
				lEnd++;
				rStart++;
			}
		}
	}
}