package com.jindal.arrays;

public class MedianOf2SortedArrsy {

	public static void main(String[] args) {
		// 7, = 1, 1,2,3,4,5,6,7,8,9,10,11,14
		// 6,8,, = 2
		// search = 1
		// !(12 &01)==0, means even, then 12/2=6 and 6+1=7

		int a[] = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 32, 35 };
		int b[] = { 21, 23, 25, 27, 29, 30, 31, 33, 34 };
		//

		System.out.println(median(a, 0, a.length - 1, b, 0, b.length - 1, 2));

	}

	static int median(int a[], int aS, int aE, int b[], int bS, int bE, int k) {
		int aLength = aE - aS + 1;
		int bLength = bE - bS + 1;

		if (k == 1) {
			return b[bS] < a[aS] ? b[bS] : a[aS];
		} else if (k == 2) {

		}
		if (aLength < 1) {
			return b[bS + k - 1];
		}

		if (bLength < 1) {
			return a[aS + k - 1];
		}

		if (bLength == 1 && aLength == 1) {
			return a[aS] < b[bS] ? a[aS] : b[bS];
		}
		if (k == 1) {
			return a[aS] < b[bS] ? a[aS] : b[bS];
		}

		int midA = aS + aLength / 2;
		int midB = bS + bLength / 2;

		int aUptoMid = (midA - aS + 1);
		int bUptoMid = (midB - bS + 1);
		int elementsUptoMid = aUptoMid + bUptoMid;
		if (k > elementsUptoMid) {
			if (a[midA] < b[midB]) {
				return median(a, midA + 1, aE, b, bS, bE, k - aUptoMid);
			} else {
				return median(a, aS, aE, b, midB + 1, bE, k - bUptoMid);
			}
		} else if (k < elementsUptoMid) {
			if (a[midA] < b[midB]) {
				return median(a, aS, aE, b, bS, midB - 1, k);
			} else {
				return median(a, aS, midA - 1, b, bS, bE, k);
			}
		} else {
			if (a[midA] < b[midB]) {
				return median(a, aS, aE, b, bS, midB, k);
			} else {
				return median(a, aS, midA, b, bS, bE, k);
			}
		}
	}

}
