package lambda.ps.ex1.q1;

import java.util.ArrayList;
import java.util.List;

public class Filter {

  public static void main(String[] args) {
    List<Integer> list = List.of(-3, -2, -1, 1, 2, 3, 5);
    System.out.println("원본 리스트: " + list.toString());

    List<Integer> negativeList = filter(list, filterCondition("negative"));
    System.out.println("음수 리스트: " + negativeList.toString());

    List<Integer> evenList = filter(list, filterCondition("even"));
    System.out.println("짝수 리스트: " + evenList.toString());
  }

  static MyPredicate filterCondition(String command) {
    return switch (command) {
      case "negative" -> (int v) -> v < 0;
      case "even" -> (int v) -> v % 2 == 0;
      default -> null;
    };
  }

  static List<Integer> filter(List<Integer> list,  MyPredicate predicate) {
    List<Integer> filteredList = new ArrayList<>();
    for(int num : list) {
      if(predicate.test(num)) filteredList.add(num);
    }
    return filteredList;
  }
}
