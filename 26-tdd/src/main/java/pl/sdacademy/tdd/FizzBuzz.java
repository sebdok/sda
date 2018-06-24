package pl.sdacademy.tdd;

class FizzBuzz {
	/**
	 * Returns a "Fizz" when {@code number} if divisible by 3, "Buzz" when divisible by 5, "FizzBuzz" when
	 * divisible by 3 and 5, and finally a string representation of a {@code number} in any other case (e.g. "1"
	 * for 1, "2" for 2).
	 *
	 * @param number a number
	 * @return the string according to the specification
	 */
	static String msg(int number) {
		switch (number){
			case 0:
				return "FizzBuzz";
			case 1:
				return "1";
			case 2:
				return "Wizz";
			case 3:
				return "FizzWizz";
			case 5:
				return "BuzzWizz";
			default:
				break;

		}

		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				if (number % 3 == 0 && number % 5 == 0) {
					return "FizzBuzz";
				}
				if (number % 3 == 0) {
					return "Fizz";
				}
				if (number % 5 == 0) {
					return "Buzz";
				}
				return String.valueOf(number);
			}

		}

		return "Wizz";

	}

}

