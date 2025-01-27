import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		if(N <= 2) {
			System.out.println(0);
			return;
		}
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int ans = 0;
		for (int i = 0; i < N; i++) {
			int v = arr[i];
			int sum = 0;
			int start = (i == 0) ? 1 : 0;
			int end = (N - 1 == i) ? N - 2 : N - 1;
			while (start < end) {
				sum = arr[start] + arr[end];
				if(sum == v) {
					ans++;
					break;
				}
				if (sum < v) {
					start += (start + 1 == i) ? 2 : 1;
				}else {
					end-= (end - 1 == i) ? 2 : 1;
				}
			}
		}
		System.out.println(ans);
	}
}