package com.jindal.arrays;

public class kThLargest2 {

	public static void main(String[] args) {

	}

	public static int kThLargest(int a[], int as, int ae, int b[], int bs, int be, int k) {

		int alen = ae - as + 1;
		int blen = be - bs + 1;

		int aK = as + ((alen) / (alen + blen) * (k - 1));
		int bK = bs + ((k - 1) - aK);

		int a_1 = aK == as ? Integer.MIN_VALUE : a[aK - 1];
		int b_1 = bK == bs ? Integer.MIN_VALUE : b[bK - 1];
		
		

		return -1;
	}

}
