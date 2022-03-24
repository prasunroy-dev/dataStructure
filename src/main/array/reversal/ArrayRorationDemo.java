package main.array.reversal;

import java.util.Arrays;

public class ArrayRorationDemo {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(Arrays.toString(rotateArrayIterativeApproach(arr)));
		
		int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(Arrays.toString(rotateArrayIterativeApproach(arr1)));


	}

	public static int[] rotateArrayIterativeApproach(int[] arr) {
		int start = 0, end = arr.length - 1;
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		return arr;
	}

	public static int[] rotateArrayUsingRecurssion(int[] arr, int s, int e) {
		if (s < e) {
			int temp = arr[s];
			arr[s] = arr[e];
			arr[e] = temp;
			rotateArrayUsingRecurssion(arr, s + 1, e - 1);
		}
		return arr;
	}

}
