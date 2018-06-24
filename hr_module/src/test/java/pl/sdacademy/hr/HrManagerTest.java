package pl.sdacademy.hr;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class HrManagerTest {
	private HrManager hrManager = new HrManager();

	@BeforeEach
	void setup(){
		hrManager = new HrManager();
	}

	@DisplayName("should create non-null new employee when is given firs name, last name and date of birth")
	@Test
	void test00() {
		//given
		String firstName = "Adam";
		String lastName = "Kowalski";
		String dateOfBirth = "01-01-1960";

		//when
		Employee employee = hrManager.create(firstName, lastName, dateOfBirth);
		//then
		Assertions.assertThat(employee).isNotNull();
	}

	@DisplayName("should create a new employee with All fields:firs name, last name and date of birth")
	@Test
	void test01() {
		//given
		String firstName = "Adam";
		String lastName = "Kowalski";
		String dateOfBirth = "01-01-1960";

		//when
		Employee employee = hrManager.create(firstName, lastName, dateOfBirth);

		//then
		Assertions.assertThat(employee.getFirsName()).isEqualTo(firstName);
		Assertions.assertThat(employee.getLastName()).isEqualTo(lastName);
		Assertions.assertThat(employee.getDateOfBirth()).isEqualTo(dateOfBirth);
	}

	@DisplayName("Should check if new Employee is add to the database")
	@Test
	void test02() {
		//given
		String firstName = "Adam";
		String lastName = "Kowalski";
		String dateOfBirth = "01-01-1960";
		Employee newEmployee = hrManager.create(firstName, lastName, dateOfBirth);
		//when
		List<Employee> allEmployees = hrManager.findAll();

		//then
		Assertions.assertThat(allEmployees).containsOnly(newEmployee);



	}
	@DisplayName("Should check if  two new Employee are added to the database")
	@Test
	void test03() {
		//given
		String firstName = "Adam";
		String lastName = "Kowalski";
		String dateOfBirth = "01-01-1960";
		Employee adam = hrManager.create("Adam", "Kowalski", "01-01-1960");
		Employee john = hrManager.create("John", "Smith", "02-01-1962");

		//when
		List<Employee> allEmployees = hrManager.findAll();

		//then
		Assertions.assertThat(allEmployees).containsOnly(adam,john);



	}
	@DisplayName("Should find single employee with given last name ")
	@Test
	void test04(){
		//given
		Employee adam = hrManager.create("Adam", "Kowalski", "01-01-1960");
		Employee john = hrManager.create("John", "Smith", "02-01-1962");
		//when
		List<Employee> foundEmployees = hrManager.serchByLastName("Kowalski");
		//then
		Assertions.assertThat(foundEmployees).containsOnly(adam);

	}
	@DisplayName("Should find every employee with given last name ")
	@Test
	void test05(){
		//given
		Employee adam = hrManager.create("Adam", "Kowalski", "01-01-1960");
		Employee john = hrManager.create("John", "Smith", "02-01-1962");
		Employee frank = hrManager.create("Frank", "Kowalski", "02-01-1980");

		//when
		List<Employee> foundEmployees = hrManager.serchByLastName("Kowalski");
		//then
		Assertions.assertThat(foundEmployees).containsOnly(adam,frank);
	}
	@DisplayName("Should find no employee when there is no employee with given last name")
	@Test
	void test06(){
		//given
		Employee adam = hrManager.create("Adam", "Kowalski", "01-01-1960");
		Employee john = hrManager.create("John", "Smith", "02-01-1962");
		Employee frank = hrManager.create("Frank", "Kowalski", "02-01-1980");

		//when
		List<Employee> foundEmployees = hrManager.serchByLastName("Pazdzioch");
		//then
		Assertions.assertThat(foundEmployees).isEmpty();
	}
	@DisplayName("Should find 2 employees when their firstName matches given search phrase")
	@Test
	void test07(){
		//given
		Employee adam = hrManager.create("Adam", "Kowalski", "01-01-1960");
		Employee johnSmith = hrManager.create("John", "Smith", "02-01-1962");
		Employee johnKowalski = hrManager.create("John", "Kowalski", "02-01-1980");
		//when
		List<Employee> foundEmployees = hrManager.serchByPhrase("John");
		//then
		Assertions.assertThat(foundEmployees).containsOnly(johnKowalski,johnSmith);
	}
	@DisplayName("Should find 2 employees when their lastName matches given search phrase")
	@Test
	void test08(){
		//given
		Employee adam = hrManager.create("Adam", "Kowalski", "01-01-1960");
		Employee johnSmith = hrManager.create("John", "Smith", "02-01-1963");
		Employee frank = hrManager.create("Frank", "Kowalski", "02-01-1980");
		//when
		List<Employee> foundEmployees = hrManager.serchByPhrase("Kowalski");
		//then
		Assertions.assertThat(foundEmployees).containsOnly(adam,frank);
	}
	@DisplayName("Should find two employees when their date of birth matches given search phrase")
	@Test
	void test09(){
		//given
		Employee adam = hrManager.create("Adam", "Kowalski", "04-03-1860");
		Employee john = hrManager.create("John", "Smith", "02-02-1980");
		Employee frank = hrManager.create("Frank", "Nowak", "02-02-1980");

		//when
		List<Employee> foundEmployees = hrManager.serchByPhrase("02-02-1980");
		//then
		Assertions.assertThat(foundEmployees).containsOnly(john,frank);
	}
	@DisplayName("Should sort by firstName ascending")
	@Test
	void test10(){
		//given
		Employee adam = hrManager.create("Adam", "Kowalski", "04-03-1860");
		Employee john = hrManager.create("John", "Smith", "02-02-1980");
		Employee frank = hrManager.create("Frank", "Nowak", "02-02-1980");

		//when
		List<Employee> sortEmployees = hrManager.sortByFirstName();
		//then
		Assertions.assertThat(sortEmployees).containsExactly(adam,frank,john);
	}
	@DisplayName("should sort two employees by firsName descending")
	@Test
	void test11(){
		//given
		Employee adam = hrManager.create("Adam", "Kowalski", "04-03-1860");
		Employee john = hrManager.create("John", "Smith", "02-02-1980");

		//when
		List<Employee> sortEmployees = hrManager.sortByFirstNameWithBuble();
		//then
		Assertions.assertThat(sortEmployees).containsExactly(john,adam);
	}
	@DisplayName("should sort three employees by firsName descending")
	@Test
	void test12(){
		//given
		Employee john = hrManager.create("John", "Smith", "02-02-1980");
		Employee adam = hrManager.create("Adam", "Kowalski", "04-03-1860");
		Employee frank = hrManager.create("Frank", "Smith", "02-02-1980");

		//when
		List<Employee> sortEmployees = hrManager.sortByFirstNameWithBuble();
		//then
		Assertions.assertThat(sortEmployees).containsExactly(john,frank,adam);
	}@DisplayName("should sort four employees by firsName descending")
	@Test
	void test13(){
		//given
		Employee john = hrManager.create("John", "Smith", "02-02-1980");
		Employee adam = hrManager.create("Adam", "Kowalski", "04-03-1860");
		Employee frank = hrManager.create("Frank", "Smith", "02-02-1980");
		Employee ben = hrManager.create("Brank", "Smith", "02-02-1980");

		//when
		List<Employee> sortEmployees = hrManager.sortByFirstNameWithBuble();
		//then
		Assertions.assertThat(sortEmployees).containsExactly(john,frank,ben,adam);
	}
}