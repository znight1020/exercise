package methodref.start.obj;

import java.util.List;

public class Person {
	private String name;

	public Person() {
		this("Unknown");
	}

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	// 정적 메서드
	public static String greeting() {
		return "Hello";
	}

	public static String greetingWithName(String name) {
		return "Hello " + name;
	}

	// 인스턴스 메서드
	public String introduce() {
		return "I am " + name;
	}

	public String introduceWithNumber(int number) {
		return "I am " + name + ", my number is " + number;
	}
}
