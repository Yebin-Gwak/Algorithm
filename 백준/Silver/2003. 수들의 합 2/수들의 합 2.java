import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = 0;
		int end = 0;
		int ans = 0;
		int sum = 0;

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		while (start < N) {
			if (sum > M || end == N)
				sum -= arr[start++];
			else
				sum += arr[end++];

			if (sum == M)
				ans++;
		}

		System.out.println(ans);

	}

}