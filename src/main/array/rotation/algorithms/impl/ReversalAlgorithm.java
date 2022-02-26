package main.array.rotation.algorithms.impl;

public class ReversalAlgorithm {
	public static void rotateArray(int[] arr, int d) {
		int n = arr.length;

		reverse(arr, 0, d - 1);
		reverse(arr, d, n - 1);
		reverse(arr, 0, n - 1);

	}

	private static void reverse(int[] arr, int start, int end) {
		int tmp;
		while (start < end) {
			tmp = arr[end];
			arr[end] = arr[start];
			arr[start] = tmp;
			start++;
			end--;
		}

	}
}
