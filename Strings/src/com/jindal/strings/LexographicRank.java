package com.jindal.strings;

import java.util.Arrays;

public class LexographicRank {

	public static void main(String[] args) {
		String s = "pranav";
		char c[] = s.toCharArray();
		Arrays.sort(c);
		long nMinusOneFac = nFac(c.length - 1);
		int index[] = new int[256];
		for (int i = 0; i < c.length; i++) {
			index[c[i]]++;
		}
		long deno = 1;
		for (int i = 0; i < 256; i++) {
			if (index[i] > 0) {
				deno = deno * index[i];
			}
		}

		int n = c.length - 1;
		int start = 0, end = c.length - 1;

		long rank = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = start; j <= end; j++) {
				if (s.charAt(i) == c[j]) {
					rank = rank + (nMinusOneFac * (j)) / deno;
					nMinusOneFac = nMinusOneFac / n;
					n--;
					deno = deno / index[c[j]];
					index[c[j]]--;
					char temp = c[j];
					moveBackward(c, j + 1, end);
					c[end] = temp;
					end--;
					break;
				}
			}
		}

		System.out.println(rank + 1);
	}

	static long nFac(int n) {
		long fac = 1;
		for (int i = n; i >= 1; i--) {
			fac = fac * i;
		}
		return fac;
	}

	static void moveForward(char c[], int s, int e) {
		for (int i = e; i >= s; i--) {
			c[i + 1] = c[i];
		}
	}

	static void moveBackward(char c[], int s, int e) {
		for (int i = s; i <= e; i++) {
			c[i - 1] = c[i];
		}
	}

	static void swap(char c[], int f, int s) {
		char c1 = c[f];
		c[f] = c[s];
		c[s] = c1;
	}
}
