package pl.sdacademy.hr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HrManager {

	List<Employee> allEmployees = new ArrayList<>();

	Employee create(String firstName, String lastName, String dateOfBirth) {
		Employee employee = new Employee(firstName, lastName, dateOfBirth);
		allEmployees.add(employee);

		return employee;
	}

	public List<Employee> findAll() {
		return allEmployees;
	}

	public List<Employee> searchByLastName(String lastName) {
		/*List<Employee> foundEmployees = new ArrayList<>();
		for (Employee employee:allEmployees){
			if (employee.getLastName().equals(lastName)){
				foundEmployees.add(employee);
			}
		}
		return foundEmployees;*/
		return allEmployees.stream().filter(employee -> employee.getLastName().contains(lastName)).collect
			(Collectors.toList());
		// bierzemy wcześniej utworzoną listę allEmployee.otwieramy strem, czytaj ciąg wszystkiego z tej listy.
		// Wszystkich. Dając możliwość operowania na każdym elemencie.
		// filtrujemy tworząc lambdę. Tworzymy lokalnie zmienną employee typu Employee.
		// geterem wyciągamy wszystkich pracowników i sprawdzamy czy w ich lastName jest nasz lastName
		// po czym collect (zbieramy) w listę, a return ją zwraca.
	}

	public List<Employee> searchByPhrase(String phrase) {

		return allEmployees.stream().filter(employee -> employee.matches(phrase)).collect(Collectors.toList());
	}

	public List<Employee> sortByFirstName() {
		/*return allEmployees.stream().sorted(Comparator.comparing(Employee::getFirstName)).collect(Collectors
			.toList()); */
		// return allEmployees.stream().sorted().collect(Collectors.toList());

		int n = allEmployees.size();
		for (int i = 0; i < n-1; i++)
			for (int j = 0; j < n-i-1; j++)
				if (allEmployees.get(j).getFirstName().compareTo(allEmployees.get(j+1).getFirstName()
				) > 0)
				{
					// swap temp and arr[i]
					Employee temp = allEmployees.get(j);
					allEmployees.set(j, allEmployees.get(j+1));
					allEmployees.set(j+1,temp);
				}
		System.out.println(allEmployees);
		return allEmployees;
	}

	public List<Employee> sortByLastName() {
		/*return allEmployees.stream().sorted(Comparator.comparing(Employee::getFirstName)).collect(Collectors
			.toList()); */
		// return allEmployees.stream().sorted().collect(Collectors.toList());
		//QuickSort
		quickSort(allEmployees, 0, allEmployees.size() - 1);

		return allEmployees;
	}

	public List<Employee> quickSort(List<Employee> employees, int low, int high){
		if (low < high)
		{
			int pi = partition(employees, low, high);

			quickSort(employees, low, pi - 1);
			quickSort(employees, pi + 1, high);
		}
		return employees;
	}

	private int partition(List<Employee> employees, int low, int high) {
		Employee pivot = employees.get(high);
		int i = low - 1;
		for (int j = low; j <= high - 1; j++){
			if(employees.get(j).getLastName().compareTo(pivot.getLastName()) <= 0){
				i++;
				Employee temp = employees.get(j);
				employees.set(j, employees.get(i));
				employees.set(i, temp);
			}
		}
		Employee temp = employees.get(i + 1);
		employees.set(i + 1, employees.get(high));
		employees.set(high, temp);
		return i + 1;
	}
}

