package pl.sdacademy.tdd.pl.sdacademy.algorytms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.sdacademy.algorytms.BubbleSort;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BubleSortTest {


	/*@DisplayName("Should return number if we given them")
	@Test

	void test00(){
		//given
		int number = 5;
		//when
		int results = BubbleSort.calculate(number);
		//then
		assertThat(results).isEqualTo(5);

	}*/

	@DisplayName("Should return two numbers when we given them")
	@Test
	void test01(){
		//given
		int[] numbersArray = new int[]{5,2};
		//when
		int[] results =BubbleSort.calculate(numbersArray);

		// then
		assertThat(results).contains(5,2);
	}
	@DisplayName("Should return two sequence numbers when we given them")
	@Test
	void test02(){
		//given
		int[] numbersArray = new int[]{39,9,3};
		//when
		int[] results =BubbleSort.calculate(numbersArray);

		// then
		assertThat(results).containsSequence(3,9,39);
	}

}
