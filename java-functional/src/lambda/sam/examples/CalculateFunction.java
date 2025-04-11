package lambda.sam.examples;

@FunctionalInterface
public interface CalculateFunction {
	int execute(int a, int b);
}
