import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];

		st = new StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		}

		long[] mod = new long[M];
		for (int i = 0; i < N; i++) {
			mod[(int) (arr[i] % M)]++;
		}

		long ans = mod[0];
		for (int i = 0; i < M; i++) {
			if (mod[i] < 2)
				continue;
			ans += (mod[i] * (mod[i] - 1)) / 2;
		}

		System.out.println(ans);
	}

}