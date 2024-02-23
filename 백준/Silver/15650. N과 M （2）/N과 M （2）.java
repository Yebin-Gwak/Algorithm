import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] numbers;
	static boolean[] visited;
	static int[] input;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		visited = new boolean[N];
		input = new int[M];

		for (int i = 0; i < N; i++)
			numbers[i] = i + 1;

		permutation(0, 0);

		System.out.print(sb.toString());

	}
	
	private static void permutation(int cnt, int start) {
		if(cnt == M) {
			for(int x : input)
				sb.append(x).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			input[cnt] = numbers[i];
			permutation(cnt + 1, i + 1);
			visited[i] = false;
		}
	}

}