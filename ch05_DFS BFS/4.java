public class Main {

	public static void recursiveFuction(int i) {
		if (i == 100) return;
		
		System.out.println(i + "번째 재귀 함수에서" + (i + 1) + "번째 재귀 함수를 호출합니다.");
		recursiveFuction(i + 1);
		System.out.println(i + "번째 재귀 함수를 종료합니다.");
	}
	
	public static void main(String[] args) {
		recursiveFuction(1);
	}

}
