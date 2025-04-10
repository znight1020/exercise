package lambda.start;

public class HelloLambda {
	public static void main(String[] args) {
		// 익명 클래스
		MyFunction anonymous = new MyFunction() {
			@Override
			public int add(int a, int b) {
				return a+b;
			}
		};
		int result1 = anonymous.add(1, 2);

		// 람다
		MyFunction lambda = (int a, int b) -> {
			return a+b;
		};
		int result2 = lambda.add(1, 2);
	}
}
