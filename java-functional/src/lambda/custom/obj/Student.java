package lambda.custom.obj;

public class Student {
	private String name;
	private int score;

	public Student(String name, int age) {
		this.name = name;
		this.score = age;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", score=" + score +
				'}';
	}
}
