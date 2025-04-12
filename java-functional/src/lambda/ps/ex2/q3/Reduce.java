package lambda.ps.ex2.q3;

import java.util.List;

public class Reduce {

  public static void main(String[] args) {
    List<Integer> list = List.of(1, 2, 3, 4);
    System.out.println("리스트: " + list.toString());

    int sum = reduce(list, 0, (v1, v2) -> v1 + v2);
    System.out.println("합(누적 +): " + sum);

    int multiply = reduce(list, 1, (v1, v2) -> v1 * v2);
    System.out.println("곱(누적 *): " + multiply);
  }

  static int reduce(List<Integer> list, int initial, MyReducer reducer) {
    int result = initial;
    for(int n : list) {
      result = reducer.reduce(result, n);
    }
    return result;
  }
}
