package main.array.rotation.algorithms;

import main.array.rotation.algorithms.impl.ArrayRotationJuglingAlgorithm;
import main.array.rotation.algorithms.impl.BasicArrayRotation;
import main.array.rotation.algorithms.impl.LeftRotateByOneAlgotithm;
import main.array.rotation.algorithms.impl.ReversalAlgorithm;

public class Demo {

	public static void main(String[] args) {
		
		System.out.println("-----BasicArrayRotationDemo-----");
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.print("Input Array : ");
		printArray(arr);
		BasicArrayRotation.rotateArray(arr, 2);
		System.out.print("Output Array : ");
		printArray(arr);
		
		System.out.println();
		System.out.println("-----LeftRotateByOneDemo-----");
		int arr1[] = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.print("Input Array : ");
		printArray(arr1);
		LeftRotateByOneAlgotithm.rotateArray(arr1, 2);
		System.out.print("Output Array : ");
		printArray(arr1);
		
		System.out.println();
		System.out.println("-----ReversalAlgorithmDemo-----");
		int arr2[] = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.print("Input Array : ");
		printArray(arr2);
		ReversalAlgorithm.rotateArray(arr2, 2);
		System.out.print("Output Array : ");
		printArray(arr2);

	}
	
	public static void printArray(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("]");
		System.out.println();
	}

}
