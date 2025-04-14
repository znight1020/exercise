package lambda.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CustomGenericFilter {
	public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
		List<T> filtered = new ArrayList<>();
		for(T val : list) {
			if(predicate.test(val)) {
				filtered.add(val);
			}
		}
		return filtered;
	}
}
