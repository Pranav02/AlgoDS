package com.jindal.arrays;

public class KthLargest {

	public static void main(String[] args) {

		/*int a[] = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };
		int b[] = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };*/

		
		int a[] = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 32, 35 };
		int b[] = { 21, 23, 25, 27, 29, 30, 31, 33, 34 };
		 

		System.out.println(kThLargest(a, 0, a.length - 1, b, 0, b.length - 1, 1));
	}

	private static int kThLargest(int a[], int as, int ae, int b[], int bs, int be, int kTh) {

		if (as > ae) {
			return b[bs + kTh - 1];
		}

		if (bs > be) {
			return a[as + kTh - 1];
		}

		int midA = as + (ae - as) / 2;
		int midB = bs + (be - bs) / 2;

		int aElementsUptoMid = (midA - as + 1);
		int bElementsUptoMid = (midB - bs + 1);

		int numOfElementsBeforeMid = aElementsUptoMid + bElementsUptoMid;

		if (numOfElementsBeforeMid == kTh) {
			if (a[midA] > b[midB]) {
				return a[midA];
			} else {
				return b[midB];
			}
		} else if (kTh < numOfElementsBeforeMid) {
			if (a[midA] >= b[midB]) {
				return kThLargest(a, as, midA - 1, b, bs, be, kTh);
			} else {
				return kThLargest(a, as, ae, b, bs, midB, kTh);
			}
		} else {
			if (a[midA] >= b[midB]) {
				return kThLargest(a, as, ae, b, midB + 1, be, kTh - bElementsUptoMid);
			} else {

				return kThLargest(a, midA + 1, ae, b, bs, be, kTh - aElementsUptoMid);
			}
		}
	}

}
