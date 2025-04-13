package lambda.generic.mains;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import lambda.generic.interfaces.GenericFunction;

public class GenericMain {

	public static void main(String[] args) {
		GenericFunction<String, String> stringFunc = (s) -> s.toUpperCase();
		GenericFunction<Integer, Integer> integerFunc = (i) -> i * i;
		GenericFunction<String, Integer> stringToIntFunc = (str) -> Integer.parseInt(str);
	}
}
