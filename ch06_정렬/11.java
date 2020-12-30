import java.util.Arrays;
import java.util.Scanner;

class Student implements Comparable<Student> {
	private String name;
	private int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}

	@Override
	public int compareTo(Student o) {
		return score - o.score;
	}
}

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Student[] student = new Student[n];
		
		for (int i = 0; i < n; ++i) {
			String name = sc.next();
			int score = sc.nextInt();
			
			student[i] = new Student(name, score);
		}
		sc.close();
		
		Arrays.sort(student);
		
		for (int i = 0; i < n; ++i) {
			System.out.print(student[i].getName() + " ");
		}
	}

}
