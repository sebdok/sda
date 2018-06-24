package pl.sdacademy.hr;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComandLineRunner {
	public static void load(String[] args, HrManager hrManager) {
		if (containsAllArgument(args)){
			createEmpolyee(args,hrManager);
		}else {
			throw new IllegalArgumentException();
			}
	}

	private static void createEmpolyee(String[] args, HrManager hrManager) {
		hrManager.create(extractArgument(args[0],"firstName"),
			extractArgument(args[1],"lastName"),
			extractArgument(args[2], "birthDay"));
	}

	private static boolean containsAllArgument(String[] args) {
		return Stream.of(args).allMatch(arg ->
			arg.contains("firstName")||
				arg.contains("lastName") ||
				arg.contains("birthDay"));
	}

	public static String extractArgument(String argument, String argumentKey){
		return argument.split(argumentKey + "=")[1];
	}

	public static List<String> list(HrManager hrManager) {
		return hrManager.findAll().stream().map(Employee::toString).collect(Collectors.toList());
	}
}

