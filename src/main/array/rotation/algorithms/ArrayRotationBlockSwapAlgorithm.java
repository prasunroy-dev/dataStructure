package main.array.rotation.algorithms;

public class ArrayRotationBlockSwapAlgorithm {

	public static void blockSwap(int[] arr, int i, int d, int n) {
		if (d > n)
			d = d % n;
		
		if (d == 0 || n == 0) {
			return;
		}
		if (d == n - d) {
			swap(arr, 0, n - d, d);
			return;
		}

		if (d < n - d) {
			swap(arr, i, n - d + i, d);
			blockSwap(arr, i, d, n - d);

		} else {
			swap(arr, i, d, n - d);
			blockSwap(arr, n - d + i, 2 * d - n, d);
		}
	}

	public static void swap(int[] arr, int fi, int si, int d) {
		int i, temp;
		for (i = 0; i < d; i++) {
			temp = arr[fi + i];
			arr[fi + i] = arr[si + i];
			arr[si + i] = temp;
		}
	}

}
