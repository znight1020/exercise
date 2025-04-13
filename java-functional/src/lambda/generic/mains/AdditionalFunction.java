package lambda.generic.mains;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

public class AdditionalFunction {

	public static void main(String[] args) {
		/*
		 * 매개변수가 2개 이상 필요한 경우 Bixxx 인터페이스를 사용하면 된다.
		 */

		BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
		add.apply(10, 20);

		BiConsumer<String, Integer> repeat = (str, iter) -> {
			for(int i = 0; i < iter; i++) {
				System.out.print(str);
			}
		};
		repeat.accept("*", 5);

		BiPredicate<Integer, Integer> isGreater = (a, b) -> a > b;
		isGreater.test(10, 20);

		/*
		 * 기본형 지원 함수형 인터페이스
		 * 오토박싱 / 언박싱으로 인한 성능 비용 발생을 줄이기 위해서 사용한다
		 * IntFunction, LongFunction, DoubleFunction
		 */
		IntFunction<String> intFunction = x -> "value: " + x;
		intFunction.apply(10);

		/*
		 * 기본형 반환 함수형 인터페이스
		 * ToIntFunction, ToLongFunction, ToDoubleFunction
		 * */
		ToIntFunction<String> toIntFunction = str -> str.length();
		toIntFunction.applyAsInt("Hello ToIntFunction");


	}
}
