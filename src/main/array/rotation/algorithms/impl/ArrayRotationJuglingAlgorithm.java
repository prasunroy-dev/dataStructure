package main.array.rotation.algorithms.impl;

public class ArrayRotationJuglingAlgorithm {
	public static void rotateArray(int[] arr, int d) {
		int n = arr.length;
		int gcd = calcGCD(d, n);
		for (int i = 0; i < d; i++) {
			int tmp = arr[i];
			int j;
			for (j = i; j < n; j += gcd) {
				if (j + gcd > n - 1) {
					arr[j] = tmp;
				} else {
					arr[j] = arr[j + gcd];
				}
			}

		}
	}

	private static int calcGCD(int a, int b) {
		if (b == 0)
			return a;
		else
			return calcGCD(b, a % b);
	}
}
