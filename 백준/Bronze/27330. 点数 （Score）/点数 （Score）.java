import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		HashSet<Integer> set = new HashSet<>();
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}

		int ans = 0;
		for (int a : arr) {
			ans += a;
			if (set.contains(ans)) {
				ans = 0;
			}
		}

		System.out.println(ans);

	}
}