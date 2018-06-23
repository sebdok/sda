package pl.sdacademy.hr;

class Employee {
	private final String dateOfBirth ;
	private final String firstName;
	private final String lastName;

	public Employee(String firstName, String lastName, String dateOfBirth ) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirsName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + " " + dateOfBirth;
	}

	public boolean matches(String phrase) {
		return firstName.contains(phrase)
			|| lastName.contains(phrase)
			|| dateOfBirth.contains(phrase);
	}
}
