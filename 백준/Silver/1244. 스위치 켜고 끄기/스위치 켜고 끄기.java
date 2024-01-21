import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (x == 1) {
				for (int j = y; j <= n; j += y) {
					if (arr[j] == 1)
						arr[j] = 0;
					else
						arr[j] = 1;
				}
			} else {
				int count = 0;
				while ((y - count > 0) && ((y + count) < n + 1)) {
					if (arr[y - count] == arr[y + count]) {
						if (arr[y - count] == 1) {
							arr[y - count] = 0;
							arr[y + count] = 0;
						}

						else {
							arr[y - count] = 1;
							arr[y + count] = 1;
						}
						count++;

					} else
						break;
				}

			}

		}
		for (int i = 1; i <= n; i++) {
			sb.append(arr[i] + " ");
			if (i % 20 == 0)
				sb.append("\n");
		}
		System.out.println(sb);

	}

}