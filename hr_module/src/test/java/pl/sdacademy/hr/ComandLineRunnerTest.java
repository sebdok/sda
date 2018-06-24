package pl.sdacademy.hr;



import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ComandLineRunnerTest {
	@DisplayName("should reject input data when 3 arguments are given and first name is empty")
	@Test
	void test00(){
		//given
		String[] args = {"lastName = Miauczynski","birthDay = 01-01-1960","anything"};
		HrManager hrManager = new HrManager();
		//when
		//przekazujemy funkcje ,ktora bedzie wywolana pozniej
		assertThatThrownBy(() -> ComandLineRunner.load(args,hrManager ))

		//then
		.isInstanceOf(IllegalArgumentException.class);
	}
	@DisplayName("should reject input date when 3 arguments are given and last name is not empty")
	@Test
	void test01(){
		//given
		HrManager hrManager = new HrManager();
		String[] args = {"firstName = Adam","birthDay = 01-01-1960","anything"};
		//when
		assertThatThrownBy(()-> ComandLineRunner.load(args,hrManager)
)
		//then
		.isInstanceOf(IllegalArgumentException.class);

	}
	@DisplayName("should reject input data when 3 arguments are given and birth day is not empty")
	@Test
	void test02(){
		//given
		String[] args = {"firstName=Adam","lastName=Miauczynski","anything"};
		ComandLineRunner clr = new ComandLineRunner();
		HrManager hrManager = new HrManager();

		//when
		//przekazujemy funkcje ,ktora bedzie wywolana pozniej
		assertThatThrownBy(() -> ComandLineRunner.load(args,hrManager))

			//then
			.isInstanceOf(IllegalArgumentException.class);
		}

	@DisplayName("should check if more then firstname, lastname, birth day is given then database isn't empty")
	@Test
	void test03(){
		//given
		HrManager hrManager = new HrManager();
		String[] args = {"firstName=Adam","lastName=Miauczynski","birthDay=01-01-1960"};
		//when
		ComandLineRunner.load(args,hrManager);
		//then
		assertThat(hrManager.findAll()).isNotEmpty();

	}
	@DisplayName("shoul check if firstName lastName and birthDay isn't empty and than database contains"+
	"single employee with the same firstName lastName birthDay ")
	@Test
	void test04(){
		HrManager hrManager = new HrManager();
		String[] args = {"firstName=Adam","lastName=Miauczynski","birthDay=01-01-1960"};
		//when
		ComandLineRunner.load(args,hrManager);
		//then
		Employee employee =hrManager.findAll().get(0);
		assertThat(employee.getFirsName()).isEqualTo("Adam");
		assertThat(employee.getLastName()).isEqualTo("Miauczynski");
		assertThat(employee.getDateOfBirth()).isEqualTo("01-01-1960");
	}
	@DisplayName("should return list of text representation of all Employee from database")
	@Test
	void test05(){
		HrManager hrManager = new HrManager();
		String[] args = {"firstName=Adam","lastName=Miauczynski","birthDay=01-01-1960"};
		ComandLineRunner.load(args,hrManager);
		//when
		List<String> allEmployees = ComandLineRunner.list(hrManager);
		//then
		assertThat(allEmployees).containsOnly("Adam Miauczynski 01-01-1960");

	}



}


