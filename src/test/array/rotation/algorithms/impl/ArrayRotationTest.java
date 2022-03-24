package test.array.rotation.algorithms.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.array.rotation.algorithms.BasicArrayRotation;
import main.array.rotation.algorithms.LeftRotateByOneAlgotithm;

class ArrayRotationTest {

	@Test
	void testBasicArrayRotation() {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		int res[] = { 3, 4, 5, 6, 7, 1, 2 };
		BasicArrayRotation.rotateArray(arr, 2);
		assertArrayEquals(arr, res);
	}
	
	@Test
	void testLeftRotateByOne() {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		int res[] = { 3, 4, 5, 6, 7, 1, 2 };
		LeftRotateByOneAlgotithm.rotateArray(arr, 2);
		assertArrayEquals(arr, res);
	}

}
