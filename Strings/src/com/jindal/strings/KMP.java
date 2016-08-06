package com.jindal.strings;

public class KMP {

	public static void main(String[] args) {
		String s = "aabbbbababacaacacacababacaacava";
		String pattern = "ababaca";
		int prefix[] = prefixPrecomputation(s.toCharArray());
		find(s, pattern, prefix);

	}

	static void find(String s, String pattern, int prefix[]) {
		int patternIndex = -1;
		for (int i = 0; i < s.length(); i++) {
			if (pattern.charAt(patternIndex + 1) == s.charAt(i)) {
				patternIndex++;
				if (patternIndex == pattern.length() - 1) {
					System.out.println(i);
					patternIndex = -1;
				}
			} else if (patternIndex > -1) {
				patternIndex = prefix[patternIndex];
			}

		}
	}

	static int[] prefixPrecomputation(char c[]) {
		int prefix[] = new int[c.length];
		int l = prefix[0] = -1;
		for (int i = 1; i < c.length; i++) {
			while (l > -1 && c[l + 1] != c[i]) {
				l = prefix[l];
			}
			if (c[l + 1] == c[i]) {
				l = l + 1;
			}
			prefix[i] = l;
		}
		return prefix;
	}

	static void print(int c[]) {
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i]);
		}
		System.out.println();
	}
}
