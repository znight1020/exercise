package lambda.generic.mains;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class BasicFunction {
	public static void main(String[] args) {
		// 자바에서는 java.util.function 패키지에서 기본 함수형 인터페이스를 제공한다.

		/*
		 * Function<T, R>
		 * 입력받은 값을 이용해 로직을 실행하고 반환하는 함수형 인터페이스
		 * */
		Function<String, String> function = (str) -> str.toUpperCase();
		function.apply("Hello Function");

		/*
		 * Consumer<T>
		 * 입력받은 데이터를 소비하는 함수형 인터페이스
		 * */
		Consumer<String> consumer = (str) -> System.out.println(str);
		consumer.accept("Hello Consumer");

		/*
		 * Supplier<T>
		 * 입력없이 데이터를 제공해주는 함수형 인터페이스
		 * 예) 랜덤 값 제공
		 * */
		Supplier<Integer> supplier = () -> new Random().nextInt(10);
		supplier.get(); // 랜덤 값

		/*
		 * Runnable
		 * 입력, 출력이 없으며 주로 쓰레드 작업을 실행하기 위한 함수형 인터페이스
		 * */
		Runnable runnable = () -> System.out.println("task execute");
		runnable.run();
	}
}
