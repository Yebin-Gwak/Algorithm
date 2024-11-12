import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		TreeMap<String, Integer> map = new TreeMap<>();

		ArrayList<Integer>[][] arr = new ArrayList[3][101];
		for (int i = 0; i < 3; i++) {
			for (int j = 1; j <= 100; j++)
				arr[i][j] = new ArrayList<>();
		}

		int N = Integer.parseInt(br.readLine());
		int[] scores = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				int v = Integer.parseInt(st.nextToken());
				arr[j][v].add(i);
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 1; j <= 100; j++) {
				if (arr[i][j].size() != 1)
					continue;
				scores[arr[i][j].get(0)] += j;
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.println(scores[i]);
		}
	}
}