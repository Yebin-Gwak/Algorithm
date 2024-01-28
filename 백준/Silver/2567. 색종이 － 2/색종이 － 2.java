import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] arr = new int[102][102];
		int ans = 0;
		int num = Integer.parseInt(br.readLine());
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					arr[j][k] += 1;
				}
			}

		}

		for (int x = 1; x < 101; x++) {
			for (int y = 1; y < 101; y++) {
				if (arr[x][y] >= 1) {
					for (int i = 0; i < 4; i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];

						if (arr[nx][ny] == 0)
							ans++;
					}
				}
			}
		}

		System.out.println(ans);
	}

}