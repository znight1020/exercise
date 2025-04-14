package lambda.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CustomGenericMap {
	public static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
		List<R> result = new ArrayList<>();
		for(T val : list) {
			result.add(mapper.apply(val));
		}
		return result;
	}
}
