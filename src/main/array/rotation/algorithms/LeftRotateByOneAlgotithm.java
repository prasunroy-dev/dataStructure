package main.array.rotation.algorithms;

public class LeftRotateByOneAlgotithm {
	
	public static void rotateArray(int[] arr, int d) {
		for (int i = 0; i < d; i++) {
			leftRotateByOne(arr);
		}
	}

	public static void leftRotateByOne(int[] arr) {
		if (arr != null) {
			int tmp = arr[0];
			int n = arr.length;
			for (int i = 0; i < n - 1; i++) {
				arr[i] = arr[i + 1];
			}
			arr[n - 1] = tmp;
		}
	}
}
