package pl.sdacademy.tdd;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class AnagramyTest {
	@DisplayName("shoould convert pies to siep")
	@Test
	@Disabled
	void pies(){
		//given
		String str= "pies";
		//when
		Set<String> piescidelko = Anagramy.converter(str);
		//then
		Assertions.assertThat(piescidelko).contains("siep");
	}
	@DisplayName("shoould convert pies to epis")
	@Test
	@Disabled
	void epis(){
		//given
		String str= "pies";
		//when
		Set<String> piescidelko = Anagramy.converter(str);
		//then
		Assertions.assertThat(piescidelko).contains("epis");
	}
	@DisplayName("shoould convert jo to all anagrams")
	@Test
	void wszystkie(){
		//given
		String str = "jo";
		//when
		Set<String> piescidelko = Anagramy.converter(str);
		//then
		Assertions.assertThat(piescidelko).containsOnly("jo", "oj");
	}
	@DisplayName("shoould convert oo to all anagrams")
	@Test
	void wszystkieoo(){
		//given
		String str = "oo";
		//when
		Set<String> piescidelko = Anagramy.converter(str);
		//then
		Assertions.assertThat(piescidelko).containsOnly("oo");
	}
	@DisplayName("shoould convert kot to all anagrams")
	@Test
	void wszystkiekot(){
		//given
		String str = "kot";
		//when
		Set<String> piescidelko = Anagramy.converter(str);
		//then
		Assertions.assertThat(piescidelko).containsOnly("kot","otk","kto","tok","okt");
	}
}
