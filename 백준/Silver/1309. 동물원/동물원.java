import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N + 1][3];

		arr[1][0] = 1;
		arr[1][1] = 1;
		arr[1][2] = 1;

		for (int i = 2; i <= N; i++) {
			arr[i][0] = (arr[i - 1][0] + arr[i - 1][1] + arr[i - 1][2]) % 9901;

			arr[i][1] = (arr[i - 1][0] + arr[i - 1][2]) % 9901;

			arr[i][2] = (arr[i - 1][0] + arr[i - 1][1]) % 9901;
		}

		System.out.println((arr[N][0] + arr[N][1] + arr[N][2]) % 9901);
	}
}