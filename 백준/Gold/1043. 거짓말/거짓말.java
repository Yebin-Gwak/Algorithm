import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static boolean[] parents;
	static ArrayList<Integer>[] parties;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		init(N);

		st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());

		for (int i = 0; i < L; i++)
			parents[Integer.parseInt(st.nextToken())] = true;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			for (int j = 0; j < l; j++)
				parties[i].add(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < M; i++) {
			for(int j = 0; j < M; j++)
				check(j);
		}

		for (int i = 0; i < M; i++)
			talk(i);

		System.out.println(ans);

	}

	private static void init(int N) {
		parents = new boolean[N + 1];

		parties = new ArrayList[M];
		for (int i = 0; i < M; i++)
			parties[i] = new ArrayList<>();
	}

	private static void check(int i) {
		for (int n : parties[i]) {
			if (parents[n]) {
				for (int m : parties[i])
					parents[m] = true;
				return;
			}
		}
	}

	private static void talk(int i) {
		for (int n : parties[i]) {
			if (parents[n])
				return;
		}
		ans++;
	}

}