
public class CoinExchange {

	public static void main(String[] args) {
		int total = 13;
		int coins[] = { 7, 3, 2, 6 };
		mininumCoins(total, coins);

	}

	static void mininumCoins(int value, int c[]) {
		int[] temp = new int[value + 1]; // min number of coins for ith value of
											// money
		int[] result = new int[value + 1]; // tells which coin to choose for jth
											// value of money

		temp[0] = 0;
		for (int i = 1; i <= value; i++) {
			temp[i] = Integer.MAX_VALUE - 1;
			result[i] = -1;
		}
		for (int i = 1; i <= value; i++) {
			for (int j = 0; j < c.length; j++) {
				if (i >= c[j]) {
					if (temp[i - c[j]] + 1 < temp[i]) {
						temp[i] = temp[i - c[j]] + 1;
						result[i] = j;
					}
				}
			}
		}

		print(result, c, value);
	}

	static void print(int result[], int coins[], int value) {
		while (value > 0) {
			System.out.println(coins[result[value]]);
			value = value - coins[result[value]];
		}
	}

}
