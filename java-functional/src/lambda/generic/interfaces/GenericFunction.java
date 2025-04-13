package lambda.generic.interfaces;

@FunctionalInterface
public interface GenericFunction<T, R> {
	R apply(T t);
}
