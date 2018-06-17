package pl.sdacademy.hr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HrManager {

	private  List<Employee> allEmployees = new ArrayList<>();

	 Employee create(String firstName, String lastName, String dateOfBirth){
		Employee employee = new Employee(firstName,lastName,dateOfBirth);
		allEmployees.add(employee);
		return employee;
	}

	public  List<Employee> findAll() {

		return allEmployees;
	}
}
