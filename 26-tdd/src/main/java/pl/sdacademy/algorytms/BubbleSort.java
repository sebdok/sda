package pl.sdacademy.algorytms;

public class BubbleSort {
	public static int[] calculate(int[] numbers) {
		//for (int i = 0; i > numbers.length - 1; i++) {
		int i = 0;
		if (numbers[i] > numbers[i + 1]) {
				int nuberHigh = numbers[i];
				int nuberLow = numbers[i + 1];
				int[] results = {nuberLow, nuberHigh};
				numbers = results;
		}
		return numbers;

	}
}



