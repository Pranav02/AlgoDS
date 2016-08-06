package com.jindal.arrays;

public class SearchInRotatedArray {

	public static void main(String[] args) {
		int a[] = { 5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 4 };
		System.out.println(search(a, 0, a.length - 1, 80));
	}

	static int search(int a[], int start, int end, int key) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (a[mid] == key) {
				return mid;
			}
			if (a[start] < a[end]) {// 54321876
				if (a[mid] > a[end]) {
					if (key < a[mid] && key >= a[end]) {
						return normalBinarySearch(a, start + 1, mid, key);
						// start = mid + 1;
					} else {
						end = mid - 1;
					}
				} else {
					if (key > a[mid] && key <= a[start]) {
						return normalBinarySearch(a, start, mid - 1, key);
						// end = mid - 1;
					} else {
						start = mid + 1;
					}

				}
			} else {// 567891234
				if (a[start] < a[mid]) {
					if (key >= a[start] && key < a[mid]) {
						return normalBinarySearch(a, start, mid - 1, key);
						// end = mid - 1;
					} else {
						start = mid + 1;
					}
				} else {
					if (key > a[mid] && key <= a[end]) {
						return normalBinarySearch(a, mid + 1, end, key);
						// start = mid + 1;
					} else {
						end = mid - 1;
					}
				}
			}
		}

		return -1;
	}

	static int normalBinarySearch(int a[], int start, int end, int key) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (a[mid] == key) {
				return mid;
			}

			if (a[start] > a[end]) {
				if (key < a[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else {
				if (key > a[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}

}
