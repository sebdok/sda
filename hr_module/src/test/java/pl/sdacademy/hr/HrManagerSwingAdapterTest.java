package pl.sdacademy.hr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;


class HrManagerAdapterTest {
	private HrManager hrManager;

	@BeforeEach
	void setup() {
		hrManager = new HrManager();
	}

	@DisplayName("should create non-null new allEmployees when is given first name, last name and date of birth ")
	@Test
	void test0() {
		//given
		String firstName = "Adam";
		String lastName = "Miauczyński";
		String dateOfBirth = "01-12-1960";
		//when
		Employee employee = hrManager.create(firstName, lastName, dateOfBirth);
		//then
		assertThat(employee).isNotNull();
	}
}