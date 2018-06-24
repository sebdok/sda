package pl.sdacademy.hr;

public class Main {
	public static void main(String[] args) {
		HrManager hrManager = new HrManager();
		ComandLineRunner.load(args,hrManager);
		ComandLineRunner.list(hrManager).forEach(System.out::println);

	}
}
