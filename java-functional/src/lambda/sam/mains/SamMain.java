package lambda.sam.mains;

import lambda.sam.interfaces.CalculateFunction;
import lambda.sam.interfaces.SamInterface;

public class SamMain {
	public static void main(String[] args) {
		SamInterface samInterface = () -> {
			System.out.println("Is SAM Interface");
		};
		samInterface.run();

		//
		/* 다중 추상 메서드를 가진 인터페이스의 경우 람다를 사용할 수 없다. (함수형 인터페이스 X)
				NoneSamInterface noneSamInterface = () -> {
					System.out.println("Is None SAM Interface");
				};
			java: incompatible types: lambda.sam.examples.NoneSamInterface is not a functional interface
		*/

		CalculateFunction add1 = (a, b) -> {
			System.out.println("a+b = " + (a+b));
			return a+b;
		};

		CalculateFunction add2 = (a, b) -> {
			System.out.println("a+b = " + (a+b));
			return a+b;
		};

		/*CalculateFunction sub = (a, b) -> {
			System.out.println("a-b = " + (a-b));
			return a-b;
		};*/

		// 같은 동작을 정의한 람다라도 JVM은 각각의 람다식을 별도의 인스턴스로 생성
		// 이때 클래스 자체도 동일하지 않을 수 있고, JVM의 구현 방식 또는 최적화 전략에 따라 달라질 수 있음
		System.out.println("add.getClass == sub.getClass : " + (add1.getClass() == add2.getClass())); // false
		System.out.println("add.Instance == sub.Instance : " + (add1 == add2)); // false
	}
}
