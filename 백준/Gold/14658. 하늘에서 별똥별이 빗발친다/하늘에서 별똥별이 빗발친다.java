import java.util.*;
import java.io.*;

public class Main {
	static class Star implements Comparable<Star> {
		int x, y;

		public Star(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Star o) {
			if (this.y == o.y)
				return this.x - o.x;
			return this.y - o.y;
		}
	}

	static int N, M, L, K;
	static Star[] stars;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		

		stars = new Star[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			stars[i] = new Star(x, y);
		}
		Arrays.sort(stars);
		
		for (int i = 0; i < K; i++)
			calc(i);

		System.out.println(K - ans);
	}

	private static void calc(int start) {
		if(ans == K)
			return;
		Star star = stars[start];
		// 기준 별 뽑고
		int x = star.x;
		int y = star.y;
		int endY = y + L;


		// y는 기준 별 좌표 고정, 트램펄린 내리면서 검사
		for (int i = 0; i < L; i++) {
			int startX = x - L + i;
			int endX = x + i + 1;

			int count = 0;
			for (int j = start; j < stars.length; j++) {
				if (startX <= stars[j].x && stars[j].x <= endX && y <= stars[j].y) {
					if (endY < stars[j].y)
						break;
					count++;
				}
			}
			ans = Math.max(ans, count);
		}

	}

}