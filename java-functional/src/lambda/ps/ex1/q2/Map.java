package lambda.ps.ex1.q2;

import java.util.ArrayList;
import java.util.List;

public class Map {

  public static void main(String[] args) {
    List<String> list = List.of("hello", "java", "lambda");
    System.out.println("원본 리스트: " + list.toString());

    List<String> upperList = map(list, mapLogic("upper"));
    System.out.println(upperList.toString());

    List<String> decorationList = map(list, mapLogic("decoration"));
    System.out.println(decorationList.toString());
  }

  static StringFunction mapLogic(String command) {
    return switch (command) {
      case "upper" -> (String str) -> str.toUpperCase();
      case "decoration" -> (String str) -> "***" + str + "***";
      default -> (String str) -> str;
    };
  }

  static List<String> map(List<String> list,  StringFunction func) {
    List<String> newList = new ArrayList<>();
    for(String str : list) {
      newList.add(func.apply(str));
    }

    return newList;
  }
}
