package pl.sdacademy.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Fail.fail;

// TODO: write your tests inside this class
class FizzBuzzTest {

	// this is how a test look like
	@DisplayName("check if the result isn't null")
	@Test
	/*void nothing() {
		// this is how you write assertions
		assertThat(1).isEqualTo(1);
		assertThat(1).isNotEqualTo(2);
		fail("remove this pseudo test and start writing your own real tests");
	}*/
	//given
		void fizzBuzzTest(){
			int a = 0;
			//when
		String sloneczko = FizzBuzz.msg(a);
		//than
		assertThat(sloneczko).isNotEmpty();

	}

	@DisplayName("if given 1 it return 1")


	@Test
	void  fizzBuzzTest1(){
		//given
		int a = 1;
		//when
		String sloneczko = FizzBuzz.msg(a);
		//than
		assertThat(sloneczko).isEqualTo("1");
	}
	@DisplayName("if given 2 it return 2")


	@Test
	void  fizzBuzzTest2(){
		//given
		int a = 2;
		//when
		String sloneczko = FizzBuzz.msg(a);
		//than
		assertThat(sloneczko).isEqualTo("Wizz");
	}
	@DisplayName("if given 3 it return \"FizzWizz\"")


	@Test
	void  fizzBuzzTest3(){
		//given
		int a = 3;
		//when
		String sloneczko = FizzBuzz.msg(a);
		//than
		assertThat(sloneczko).isEqualTo("FizzWizz");
	}
	@DisplayName("if given 5 it return \"Buzz\"")


	@Test
	void  fizzBuzzTest5(){
		//given
		int a = 5;
		//when
		String sloneczko = FizzBuzz.msg(a);
		//than
		assertThat(sloneczko).isEqualTo("BuzzWizz");
	}
	@DisplayName("if given 7 it return \"Wizz\"")


	@Test
	void  fizzBuzzTest7(){
		//given
		int a = 7;
		//when
		String sloneczko = FizzBuzz.msg(a);
		//than
		assertThat(sloneczko).isEqualTo("Wizz");
	}
	@DisplayName("if given 6 it return \"Fizz\"")


	@Test
	void  fizzBuzzTest6(){
		//given
		int a = 6;
		//when
		String sloneczko = FizzBuzz.msg(a);
		//than
		assertThat(sloneczko).isEqualTo("Fizz");
	}
	@DisplayName("if given 10 it return \"Buzz\" ")


	@Test
	void  fizzBuzzTest10(){
		//given
		int a = 10;
		//when
		String sloneczko = FizzBuzz.msg(a);
		//than
		assertThat(sloneczko).isEqualTo("Buzz");
	}
	@DisplayName("if given 12 it return \"Fizz\"")


	@Test
	void  fizzBuzzTest12(){
		//given
		int a = 12;
		//when
		String sloneczko = FizzBuzz.msg(a);
		//than
		assertThat(sloneczko).isEqualTo("Fizz");
	}
	@DisplayName("if given 15 it return \"FizzBuzz\"")


	@Test
	void  fizzBuzzTest15(){
		//given
		int a = 15;
		//when
		String sloneczko = FizzBuzz.msg(a);
		//than
		assertThat(sloneczko).isEqualTo("FizzBuzz");
	}

	@DisplayName("if given 17389 it return \"Wizz\"")


	@Test
	void  fizzBuzzTest16(){
		//given
		int a = 17389;
		//when
		String sloneczko = FizzBuzz.msg(a);
		//than
		assertThat(sloneczko).isEqualTo("Wizz");
	}



}
