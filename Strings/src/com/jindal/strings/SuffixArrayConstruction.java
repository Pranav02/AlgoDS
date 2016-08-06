package com.jindal.strings;
import java.util.Arrays;
import java.util.Comparator;

public class SuffixArrayConstruction {

	public static void main(String[] args) {

		String s = "missisippi";
		SortIndex sortIndexArr[] = new SortIndex[s.length()];
		int inverseIndex[] = new int[s.length()];
		int n = s.length();

		for (int i = 0; i < s.length(); i++) {
			sortIndexArr[i] = new SortIndex();
			sortIndexArr[i].actualIndex = i;
			sortIndexArr[i].previousRank = s.charAt(i) - 'a';
			sortIndexArr[i].currentRank = (i + 1 < n) ? (s.charAt(i + 1) - 'a') : -1;
		}


		for (int z = 0; z < n; z++) {
			System.out.println(sortIndexArr[z].actualIndex + " " + s.substring(sortIndexArr[z].actualIndex));
		}
		
		System.out.println("--------");
		
		SortSuffixArrayComparator comparator = new SortSuffixArrayComparator();
		Arrays.sort(sortIndexArr, comparator);

		for (int z = 0; z < n; z++) {
			System.out.println(sortIndexArr[z].actualIndex + " " + s.substring(sortIndexArr[z].actualIndex));
		}
		
		System.out.println("--------");
		
		for (int i = 4; i < 2 * n; i = i * 2) {// i = length up to which
												// prefixes will be sorted

			int rank = 0;
			int previousRank = sortIndexArr[0].previousRank;
			sortIndexArr[0].previousRank = 0;
			inverseIndex[sortIndexArr[0].actualIndex] = 0;
			for (int j = 1; j < n; j++) {
				if (sortIndexArr[j].previousRank == previousRank
						&& sortIndexArr[j - 1].currentRank == sortIndexArr[j].currentRank) {
					previousRank = sortIndexArr[j].previousRank;
					sortIndexArr[j].previousRank = rank;
				} else {
					previousRank = sortIndexArr[j].previousRank;
					sortIndexArr[j].previousRank = ++rank;
				}
				inverseIndex[sortIndexArr[j].actualIndex] = j;
			}

			for (int k = 0; k < n; k++) {
				int nextIndex = sortIndexArr[k].actualIndex + i / 2;
				sortIndexArr[k].currentRank = nextIndex < n ? sortIndexArr[inverseIndex[nextIndex]].previousRank : -1;
			}
			Arrays.sort(sortIndexArr, comparator);
			for (int z = 0; z < n; z++) {
				System.out.println(sortIndexArr[z].actualIndex + " " + s.substring(sortIndexArr[z].actualIndex));
			}
			
			System.out.println("--------");
		}

		int suffixArray[] = new int[n];
		for (int i = 0; i < n; i++) {
			suffixArray[i] = sortIndexArr[i].actualIndex;
		}

		for (int i = 0; i < n; i++) {
			System.out.println(suffixArray[i] + " " + s.substring(suffixArray[i]));
		}

		int lcp[] = contructLCP(suffixArray, s);

		/*System.out.println("LCP ARRAY");
		for (int i = 0; i < n; i++) {
			System.out.println(lcp[i]);
		}*/

	}

	static int[] contructLCP(int[] suffixArray, String s) {
		int lcp[] = new int[suffixArray.length];
		int n = suffixArray.length;

		int reverseIndex[] = new int[lcp.length];

		for (int i = 0; i < n; i++) {
			reverseIndex[suffixArray[i]] = i;
		}

		int k = 0;
		for (int i = 0; i < n; i++) {
			if (reverseIndex[i] == n - 1) {
				k = 0;
				continue;
			}
			int j = suffixArray[reverseIndex[i] + 1];
			while (k + i < n && k + j < n && s.charAt(k + j) == s.charAt(k + i)) {
				k++;
			}
			lcp[reverseIndex[i]] = k;
			if (k > 0) {
				k--;
			}
		}
		return lcp;
	}

	static class SortSuffixArrayComparator implements Comparator<SortIndex> {
		@Override
		public int compare(SortIndex o1, SortIndex o2) {
			return (o1.previousRank == o2.previousRank ? (o1.currentRank < o2.currentRank ? -1 : 1)
					: (o1.previousRank < o2.previousRank ? -1 : 1));

		}
	}

	static class SortIndex {
		int actualIndex;

		int previousRank;
		int currentRank;
	}

}
