package com.jindal.arrays;

public class SecondLargest {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int mid = a.length / 2;

		int left = secondLargest(a, 0, mid);
		int right = secondLargest(a, mid + 1, a.length - 1);

		System.out.println(left);
		System.out.println(right);
	}

	static int secondLargest(int a[], int s, int e) {
		if (s == e) {
			return a[s];
		} else if ((e - s) == 1) {
			return a[e] > a[s] ? a[e] : a[s];
		} else {
			int mid = s + (e - s) / 2;
			int left = secondLargest(a, s, mid);
			int right = secondLargest(a, mid + 1, e);

			return left > right ? left : right;
		}
	}
}
