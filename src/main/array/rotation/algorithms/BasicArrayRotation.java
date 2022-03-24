package main.array.rotation.algorithms;

public class BasicArrayRotation {

	public static void rotateArray(int[] arr, int d) {
		int n = arr.length;
		int[] tmp = new int[d];
		for (int i = 0; i < d; i++) {
			tmp[i] = arr[i];
		}
		for (int i = 0; i < n - d; i++) {
			arr[i] = arr[i + d];
		}
		int j = 0;
		for (int i = n - d; i < n; i++) {
			arr[i] = tmp[j++];
		}
	}

	

}
