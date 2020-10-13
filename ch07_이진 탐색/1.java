import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("생성할 원소 개수를 입력한 다음 한 칸 띄고 찾을 문자열을 입력하세요.");
		int n = sc.nextInt();
		String str = sc.next();
		sc.nextLine();
		
		System.out.println("앞서 적은 원소 개수만큼 문자열을 입력하세요. 구분은 띄어쓰기 한 칸으로 합니다.");
		String inputData[] = sc.nextLine().split(" ");
		sc.close();
		
		for (int i = 0; i < n; ++i) {
			if (inputData[i].equals(str)) {
				System.out.print(i + 1);
				break;
			}
		}
	}

}
