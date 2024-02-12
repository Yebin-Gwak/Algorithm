import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken()); // 떨어지는 자두 개수
		int W = Integer.parseInt(st.nextToken()); // 최대 이동 횟수
		int[][]tree = new int[T + 1][W + 1];
		int ans = 0;

		for (int i = 1; i <= T; i++) {
			int value = Integer.parseInt(br.readLine());

			if (value == 1)
				tree[i][0] = tree[i - 1][0] + 1;
			else
				tree[i][0] = tree[i - 1][0];
			
			for (int j = 1; j <= W; j++) {
				if (j % 2 == 1) { //홀수번 움직인 경우(2번 나무에 위치)
					if(value == 1) // 1번 나무에 떨어진 경우
						tree[i][j] = Math.max(tree[i-1][j-1] + 1, tree[i-1][j]);
					else
						tree[i][j] = Math.max(tree[i-1][j-1], tree[i-1][j] + 1);
					}

				else { //짝수번 움직인 경우(1번 나무에 위치)
					if(value == 1) 
						tree[i][j] = Math.max(tree[i-1][j-1], tree[i-1][j] + 1);
					else
						tree[i][j] = Math.max(tree[i-1][j-1] + 1, tree[i-1][j]);
				}
			}
		}

		for(int i = 0; i <= W; i++)
			ans = Math.max(ans, tree[T][i]);

		System.out.println(ans);
	}

}