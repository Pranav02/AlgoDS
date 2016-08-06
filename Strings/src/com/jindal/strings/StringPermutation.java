package com.jindal.strings;

public class StringPermutation {

	private static int count = 0;

	public static void main(String[] args) {
		String s = "Instantaneous";
		permute(s.toCharArray(), 0);
		System.out.println(count);

	}

	static void permute(char c[], int start) {
		if (start >= c.length - 1) {
			print(c);
			count++;
			return;
		}

		permute(c, start + 1);
		char previous = 0;
		for (int i = start + 1; i < c.length; i++) {
			if (c[i] == previous || c[start] == c[i]) {
				previous = c[i];
				continue;
			}
			previous = c[i];
			char master = c[i];
			moveForward(c, start, i - 1);
			c[start] = master;
			permute(c, start + 1);
			moveBackward(c, start + 1, i);
			c[i] = master;
		}
	}

	static void swap(char c[], int f, int s) {
		char c1 = c[f];
		c[f] = c[s];
		c[s] = c1;
	}

	static void print(char c[]) {
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i]);
		}
		System.out.println();
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

}
