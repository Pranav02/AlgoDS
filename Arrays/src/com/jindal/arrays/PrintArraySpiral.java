package com.jindal.arrays;

public class PrintArraySpiral {

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3},{ 4, 5, 21 }, { 6, 7, 8},{ 9, 10, 22 }, { 11, 12, 13},{ 14, 15, 23 },
				{ 16, 17, 18},{ 19, 20, 24 } };
		print(a, 8, 3);

	}

	/**
	 * 1,2,3,
	 * 4,5,21 
	 * 6,7,8,
	 * 9,10,22 
	 * 11,12,13,
	 * 14,15,23 
	 * 16,17,18,
	 * 19,20,24
	 */
	public static void print(int a[][], int n, int m) {
		System.out.println();
		int l = 0, r = m - 1, t = 0, b = n - 1;

		while (l <= r && t <= b) {
			for (int i = l; i <= r; i++) {
				System.out.println(a[t][i]);
			}
			t++;
			for (int j = t; j <= b; j++) {
				System.out.println(a[j][r]);
			}
			r--;

			if(t<=b)
			for (int k = r; k >= l; k--) {
				System.out.println(a[b][k]);
			}
			b--;
			
			if(l<=r)
			for (int z = b; z >= t; z--) {
				System.out.println(a[z][l]);
			}
			l++;
		}

	}

}
