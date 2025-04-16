package methodref.start;

import java.util.List;

import javax.xml.namespace.QName;

import lambda.custom.CustomStream;
import methodref.start.obj.Person;

public class MRUseMain {

	public static void main(String[] args) {
		List<Person> persons = List.of(
				new Person("Lee"),
				new Person("Kim"),
				new Person("Park")
		);

		CustomStream.of(persons)
				.map(Person::introduce)
				.map(String::toUpperCase)
				.forEach(System.out::println);
	}
}
