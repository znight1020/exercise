package lambda.generic.mains;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class SpecialFunction {

	public static void main(String[] args) {
		/*
		 * Predicate<T>
		 * 입력받은 데이터가 조건 식을 충족하는지 판단해주는 함수형 인터페이스
		 * */
		Predicate<Integer> isEvenPredicate = (num) -> num % 2 == 0;
		boolean result = isEvenPredicate.test(10);

		/*
		 * Operator
		 * 같은 타입의 값들을 받아서 동일한 타입의 결과를 반환한다.
		 * UnaryOperator : 단항 연산
		 * BinaryOperator : 이항 연산
		 * */
		UnaryOperator<Integer> unaryOperator = (num) -> num * num;
		unaryOperator.apply(10);

		BinaryOperator<Integer> binaryOperator = (n1, n2) -> n1 + n2;
		// = BiFunction<Integer, Integer, Integer> biFunction = (n1, n2) -> n1 + n2;
		binaryOperator.apply(10, 20);


		/**
		 * 위 함수형 인터페이스들은 충분히 Function, BiFunction 인터페이스로도 구현할 수 있다.
		 * 하지만, 위와 같이 명시해준 이유는 코드의 가독성과 유지보수성을 높이고 작성 의도를 쉽게 알아볼 수 있도록 해주기 위함이다.
		 * */
	}
}
