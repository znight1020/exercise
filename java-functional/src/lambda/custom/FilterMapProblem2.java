package lambda.custom;

import java.util.ArrayList;
import java.util.List;

import lambda.custom.obj.Student;

public class FilterMapProblem2 {
	/* 문제 2
	 * 점수가 80점 이상인 학생의 이름을 추출해라.
	 * direct() 에 람다를 사용하지 않고 for, if 등의 코드를 직접 작성해라.
	 * lambda() 에 앞서 작성한 필터와 맵을 사용해서 코드를 작성해라
	 * */
	public static void main(String[] args) {
		// 점수가 80점 이상인 학생의 이름을 추출해라.
		List<Student> students = List.of(
				new Student("Apple", 100),
				new Student("Banana", 80),
				new Student("Berry", 50),
				new Student("Tomato", 40)
		);
		List<String> directResult = direct(students);
		System.out.println("directResult = " + directResult);
		List<String> lambdaResult = lambda(students);
		System.out.println("lambdaResult = " + lambdaResult);
	}
	private static List<String> direct(List<Student> students) {
		List<String> names = new ArrayList<>();
		for(Student student : students) {
			if(student.getScore() >= 80) {
				names.add(student.getName());
			}
		}
		return names;
	}
	private static List<String> lambda(List<Student> students) {
		List<Student> filteredStudents = CustomGenericFilter.filter(students, (s) -> s.getScore() >= 80);
		List<String> mappedStudents = CustomGenericMap.map(filteredStudents, (s) -> s.getName());
		return mappedStudents;
	}
}
