package main.array.rearrange;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Rearrange an array such that arr[i] = i 
 * Given an array of elements of length
 * N, ranging from 0 to N –1. All elements may not be present in the array. If
 * the element is not present then there will be -1 present in the array.
 * Rearrange the array such that A[i] = i and if i is not present, display -1 at
 * that place.
 * 
 * Examples:
 * 
 * Input : arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1} 
 * Output : [-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]
 * 
 * Input : arr = {19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2, 14, 17, 4} 
 * Output : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
 *
 */

public class RearrangeArray {

	public static void main(String[] args) {
		//int[] arr = { 2, 4, 1, 6, 3, 5 };
		//reArrangeBySwapingElement(arr);

		//int[] arr1 = { -1, -1, 6, 1, 9, 3, 2, -1, 4, -1 };
		//reArrangeusingSet(arr1);
		
		int[] arr2 = { 2, 4, 1, 6, 3, 5 ,-1, 9};
		reArrangeusingApproach3(arr2);
	}

	/**
	 * 
	 * Approach (Swap elements in Array) : 
	 * 1) Iterate through elements in an array
	 * 2) If arr[i] >= 0 && arr[i] != i, put arr[i] at i ( swap arr[i] with arr[arr[i]])
	 * 
	 */

	public static void reArrangeBySwapingElement(int[] inputArr) {
		for (int i = 0; i < inputArr.length;) {
			if (inputArr[i] >= inputArr.length) {
				inputArr[i] = -1;
				continue;
			}

			if (inputArr[i] >= 0 && inputArr[i] != i) {
				int tmp = inputArr[inputArr[i]];
				inputArr[inputArr[i]] = inputArr[i];
				inputArr[i] = tmp;
			} else {
				i++;
			}
		}
		System.out.println("Rearranging by swaping element--------");
		System.out.println(Arrays.toString(inputArr));
	}

	/**
	 * 
	 * Another Approach (Using Set) : 
	 * 1) Store all the numbers present in the array into a Set 
	 * 2) Iterate through the length of the array, if the corresponding 
	 * position element is present in the Set, then set A[i] = i, else A[i] = -1
	 * 
	 */

	public static void reArrangeusingSet(int[] inputArr) {
		Set<Integer> s = new HashSet<Integer>();
		Arrays.stream(inputArr).forEach(i -> s.add(i));
		for (int i = 0; i < inputArr.length; i++) {
			if (s.contains(i))
				inputArr[i] = i;
			else
				inputArr[i] = -1;
		}
		System.out.println("Rearranging Using Set--------");
		System.out.println(Arrays.toString(inputArr));
	}
	
	/**
	 * 
	 * 1. Nav­i­gate through the array. 
	 * 2. Check if a[i] = -1, if yes then ignore it. 
	 * 
	 * 3. If a[i] != -1, Check if element a[i] is at its cor­rect posi­tion
	 * (i=A[i]). If yes then ignore it. 4. If a[i] != -1 and ele­ment a[i] is not at
	 * its cor­rect posi­tion (i!=A[i]) then place it to its correct posi­tion, but
	 * there are two conditions:
	 * 
	 * Either A[i] is vacate, means A[i] = -1, then just put A[i] = i . 
	 * OR A[i] is not vacate, means A[i] = x, then int y=x put A[i] = i. Now, we need to place
	 * y to its cor­rect place, so repeat from step 3.
	 * 
	 */
	
	public static void reArrangeusingApproach3(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > arr.length) {
				arr[i] = -1;
			}
			if (arr[i] >= 0 && arr[i] != i) {
				int x = arr[i];
				// check if desired place is not vacant
				while (arr[x] != -1 && arr[x] != x) {
					// store the value from desired place
					int y = arr[x];
					// place the x to its correct position
					arr[x] = x;
					// now y will become x, now search the place for x
					x = y;
				}
				// place the x to its correct position
				arr[x] = x;
				// check if while loop hasn't set the correct value at A[i]
				if (arr[i] != i) {
					// if not then put -1 at the vacated place
					arr[i] = -1;
				}
			}
		}
		System.out.println("Rearranging by swaping element--------");
		System.out.println(Arrays.toString(arr));
	}

}
