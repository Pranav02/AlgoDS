package com.jindal.strings;

public class ReverseStrings {

	public static void main(String[] args) {
		System.out.println(reverseWords(" i like   too much    love you"));
	}

	static String reverseWords(String s) {

		StringBuilder newString = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			while (i < s.length() && s.charAt(i) == ' ') {
				newString.append("" + s.charAt(i));
				i++;
			}

			int start = i;
			while (i < s.length() && s.charAt(i) != ' ') {
				i++;
			}
			i--;
			for (int j = i; j >= start; j--) {
				newString.append("" + s.charAt(j));
			}

		}

		return newString.toString();
	}

}
