import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int start = 0;
		int end = 0;
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		while (end < N) {
			int temp = arr[end] - arr[start];

			if (temp < M)
				end++;

			else if (temp > M) {
				ans = Math.min(ans, temp);
				start++;
			} else {
				System.out.println(M);
				return;
			}
		}

		System.out.println(ans);
	}

}