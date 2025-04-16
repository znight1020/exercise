package methodref.start;

import java.util.function.Function;
import java.util.function.Supplier;

import methodref.start.obj.Person;

public class MRMain {

	public static void main(String[] args) {
		// 정적 메서드 참조
		Supplier<String> staticMethod1 = Person::greeting;
		System.out.println(staticMethod1.get());

		// 특정 객체의 인스턴스 참조
		Person person = new Person("LEE");
		Supplier<String> instanceMethod = person::introduce;
		System.out.println(instanceMethod.get());

		// 생성자 참조
		Supplier<Person> newPerson = Person::new;
		System.out.println(newPerson.get());

		/**
		 * 임의 객체의 메서드 참조 (특정 타입)
		 */
		Person person1 = new Person("Lee");
		Person person2 = new Person("Kim");
		Person person3 = new Person("Park");

		Function<Person, String> func1 = (Person p) -> p.introduce();
		System.out.println("person1.introduce = " + func1.apply(person1));
		System.out.println("person2.introduce = " + func1.apply(person2));
		System.out.println("person3.introduce = " + func1.apply(person3));

		// 메서드 참조, 타입(객체)이 첫 번째 매개변수가 된다.
		// 첫 번째 매개변수의 메서드를 호출하고, 나머지는 순서대로 매개변수에 전달한다.
		Function<Person, String> func2 = Person::introduce;
		System.out.println("person1.introduce = " + func2.apply(person1));
		System.out.println("person2.introduce = " + func2.apply(person2));
		System.out.println("person3.introduce = " + func2.apply(person3));

		// 인스턴스 메서드 참조와 다른 점은 실행 시점에 호출되는 메서드가 달라진다는 것이다.
		// 2. 인스턴스 메서드 참조는 호출할 인스턴스 메서드가 지정되어 있지만,
		// 4. 임의 객체의 메서드 참조는 호출되는 시점에 사용할 인스턴스 메서드가 결정된다.

	}
}
