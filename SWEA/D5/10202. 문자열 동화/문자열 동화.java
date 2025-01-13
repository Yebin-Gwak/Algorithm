import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][26];

			for (int i = 0; i < 3; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[j][s.charAt(j) - 'a']++;
				}
			}

			int ans = 0;
			for (int i = 0; i < N; i++) {
				Arrays.sort(arr[i]);
				ans += 3 - arr[i][25];
			}

			sb.append("#" + tc + " " + ans).append("\n");
		}
		System.out.print(sb.toString());

	}

}