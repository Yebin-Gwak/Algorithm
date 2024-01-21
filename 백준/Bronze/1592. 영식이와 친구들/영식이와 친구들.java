import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];
		int ans = 0;
		int idx = 1;

		while (true) {
			arr[idx]++;
			if (arr[idx] == M)
				break;
			if (arr[idx] % 2 == 1)
				idx = next(idx, L, N);
			else
				idx = prev(idx, L, N);
			ans++;
		}
		System.out.println(ans);

	}

	public static int next(int idx, int L, int max) {
		int result = idx + L;
		while (result > max)
			result -= max;
		return result;
	}

	public static int prev(int idx, int L, int max) {
		int result = idx - L;
		while (result < 1)
			result += max;
		return result;
	}

}