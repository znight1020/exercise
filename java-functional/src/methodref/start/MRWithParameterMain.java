package methodref.start;

import java.util.function.BiFunction;
import java.util.function.Function;

import methodref.start.obj.Person;

public class MRWithParameterMain {

	public static void main(String[] args) {
		// 정적 메서드 참조
		Function<String, String> staticMethod1 = name -> Person.greetingWithName(name);
		Function<String, String> staticMethod2 = Person::greetingWithName; // 매개변수 생략

		// 특정 객체의 인스턴스 참조
		Person person = new Person("LEE");
		Function<Integer, String> instanceMethod1 = n -> person.introduceWithNumber(n);
		Function<Integer, String> instanceMethod2 = person::introduceWithNumber;

		// 생성자 참조
		Function<String, Person> newPerson1 = name -> new Person(name);
		Function<String, Person> newPerson2 = Person::new;

		// 임의 객체의 메서드 참조 (특정 타입)
		Person p = new Person("KIM");
		BiFunction<Person, Integer, String> biFunction = Person::introduceWithNumber;
		System.out.println(biFunction.apply(p, 1));

		/*
		 * 함수형 인터페이스의 시그니처는 매개변수와 반환타입이 정해져 있고,
		 * 컴파일러가 해당 시그니처를 바탕으로 메서드 참조와 연결해준다.
		 * 따라서, 명시적으로 매개변수를 작성하지 않아도 자동으로 추론되어 호출된다.
		 * */
	}
}
