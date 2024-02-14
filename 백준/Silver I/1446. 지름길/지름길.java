import java.io.*;
import java.util.*;

public class Main {

	static class Road {
		int start;
		int end;
		int distance;

		public Road(int start, int end, int distance) {
			this.start = start;
			this.end = end;
			this.distance = distance;
		}
	}

	static int N, D;
	static Road[] roads;
	static int[] distances;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		roads = new Road[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			roads[i] = new Road(start, end, distance);
		}

		distances = new int[D + 1];

		calc();

		System.out.println(distances[D]);
	}

	private static void calc() {
		for (int i = 0; i <= D; i++) {
			distances[i] = i; 
			for (Road r : roads) {
				if (r.start < i && r.end <= D) {
					distances[r.end] = Math.min(distances[r.end], distances[r.start] + r.distance);
				}
			}
			if (i > 0)
				distances[i] = Math.min(distances[i], distances[i - 1] + 1);
		}

	}

}