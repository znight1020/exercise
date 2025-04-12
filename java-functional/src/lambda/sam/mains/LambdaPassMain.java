package lambda.sam.mains;

import lambda.sam.interfaces.CalculateFunction;

public class LambdaPassMain {

  public static void main(String[] args) {
    CalculateFunction add = (a, b) -> a+b;
    CalculateFunction sub = (a, b) -> a-b;
    calculate(add);
    calculate(sub);

    CalculateFunction func1 = getOperation("add");
    func1.execute(1, 2);
  }

  // 람다 반환
  static CalculateFunction getOperation(String operation) {
    return switch (operation) {
      case "add" -> (a, b) -> a + b;
      case "sub" -> (a, b) -> a - b;
      default -> (a, b) -> 0;
    };
  }

  // 람다 전달
  static void calculate(CalculateFunction func) {
    int a = 1, b = 2;

    System.out.println("계산 시작");
    int result = func.execute(a, b);
    System.out.println("계산 결과 : " + result);
  }
}
