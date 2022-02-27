package main.array.rotation.algorithms.impl;

public class ArrayRotationJuglingAlgorithm {
	
	public static void rotateArray(int[] arr, int d) {
		int n = arr.length;
		d = d % n;
		int gcd = calcGCD(d, n);
		int i, j, k, temp;
		for (i = 0; i < gcd; i++) {
			temp = arr[i];
			j = i;
			while (true) {
				k = j + d;
				if (k >= n)
					k = k - n;
				if (k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}

	}
	
	

	private static int calcGCD(int a, int b) {
		if (b == 0)
			return a;
		else
			return calcGCD(b, a % b);
	}
}
