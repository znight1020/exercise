package lambda.custom;

import java.util.ArrayList;
import java.util.List;
import lambda.custom.obj.Student;

public class StreamMain {

  public static void main(String[] args) {
    List<Student> students = List.of(
        new Student("Apple", 100),
        new Student("Banana", 80),
        new Student("Berry", 50),
        new Student("Tomato", 40),
        new Student("Mango", 90)
    );

    // 점수가 80점 이상인 학생의 이름 추출
    List<String> result1 = CustomStream.of(students)
        .filter((s) -> s.getScore() >= 80)
        .map((s) -> s.getName())
        .toList();

    // 점수가 80점 이상, 이름이 5글자인 학생의 이름을 대문자로 추출
    CustomStream.of(students)
        .filter((s) -> s.getScore() >= 80)
        .filter((s) -> s.getName().length() == 5)
        .map((s) -> s.getName().toUpperCase())
        .forEach((name) -> System.out.println(name));
  }
}
