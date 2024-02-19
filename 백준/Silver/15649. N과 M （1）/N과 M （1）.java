import java.util.*;
import java.io.*;

public class Main {
	static int[] numbers;
	static boolean[] isSelected;
	static int N, M;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		numbers = new int[N + 1];
		isSelected = new boolean[N + 1];

		recursion(0);
		sc.close();
	}

	private static void recursion(int cnt) {
		if (cnt == M) {
			st = new StringTokenizer(Arrays.toString(numbers), "[],");
			for (int j = 1; j <= M; j++)
				System.out.print(st.nextToken());
			System.out.print("\n");

			return;

		}

		for (int i = 1; i <= N; i++) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			numbers[cnt] = i;
			recursion(cnt + 1);
			isSelected[i] = false;

		}

	}

}