package lambda.custom;

import java.util.ArrayList;
import java.util.List;

public class FilterMapProblem1 {
	/* 문제 1
	 * 리스트에 있는 값 중에 짝수만 남기고, 남은 짝수 값의 2배를 반환해라.
	 * direct()에 람다, 앞서 작성한 유틸리티를 사용하지 말고, for, if 등으로 코드를 직접 작성해라.
	 * lambda()에 앞서 작성한 필터와 맵을 사용해서 코드를 작성하라
	 * */
	public static void main(String[] args) {
		// 짝수만 남기고, 남은 값의 2배를 반환
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> directResult = direct(numbers);
		System.out.println("directResult = " + directResult);
		List<Integer> lambdaResult = lambda(numbers);
		System.out.println("lambdaResult = " + lambdaResult);
	}

	static List<Integer> direct(List<Integer> numbers) {
		// TODO 코드 작성
		List<Integer> filtered = new ArrayList<>();
		for(int n : numbers) {
			if(n % 2 == 0) filtered.add(2 * n);
 		}
		return filtered;
	}

	static List<Integer> lambda(List<Integer> numbers) {
		// TODO 코드 작성
		List<Integer> filtered = CustomGenericFilter.filter(numbers, (number) -> number % 2 == 0);
		return CustomGenericMap.map(filtered, (n) -> n * 2);
	}
}
