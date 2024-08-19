import java.util.*;
import java.io.*;

public class Main {

	static int goal;
	static int N;
	static int[] costs;
	static int[] customers;
	static int[] answer = new int[100300];
	static int a = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		goal = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		costs = new int[N];
		customers = new int[N];

		Arrays.fill(answer, -1);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			costs[i] = Integer.parseInt(st.nextToken());
			customers[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			answer[costs[i]] = Math.max(answer[costs[i]], customers[i]);
			if(answer[costs[i]] >= goal) {
				a = Math.min(a, costs[i]);
			}
		}

		for (int i = 1; i <= 100101; i++) {
			if (answer[i] == -1)
				continue;

			for (int j = 0; j < N; j++) {
				answer[i + costs[j]] = Math.max(answer[i + costs[j]], answer[i] + customers[j]);
				if (answer[i + costs[j]] >= goal) {
					a = Math.min(a, i + costs[j]);
				}
			}

		}

		System.out.println(a);

	}
	
}