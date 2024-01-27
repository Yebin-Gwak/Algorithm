import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[1001][1001];
		int[] ans = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			for (int j = x; j < (x + h); j++) {
				for (int k = y; k < (y + w); k++)
					arr[j][k] = i;
			}
		}

		for (int[] x : arr) {
			for (int y : x)
				ans[y]++;
		}

		for (int i = 1; i < ans.length; i++) {
			System.out.println(ans[i]);
		}

	}

}