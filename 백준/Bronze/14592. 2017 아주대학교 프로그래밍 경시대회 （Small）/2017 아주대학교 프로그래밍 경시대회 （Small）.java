import java.util.*;
import java.io.*;

public class Main {
	static class Result implements Comparable<Result>{
		int idx;
		int score;
		int submit;
		int time;
		
		public Result(int idx, int score, int submit, int time) {
			this.idx = idx;
			this.score = score;
			this.submit = submit;
			this.time = time;
		}

		public int compareTo(Result o) {
			if(this.score == o.score) {
				if(this.submit == o.submit) {
					return this.time - o.time;
				}
				return this.submit - o.submit;
			}
			return o.score - this.score;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Result> pq = new PriorityQueue<>();
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int score = Integer.parseInt(st.nextToken());
			int submit = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			pq.add(new Result(i + 1, score, submit, time));
		}
		
		Result ans = pq.poll();
		System.out.println(ans.idx);

	}
}