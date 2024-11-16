import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}
		
		Long score = 0L;
		while(pq.size() != 1) {
			Long a = pq.poll();
			Long b = pq.poll();
			score += a * b;
			pq.add(a + b);

		}
		System.out.println(score);
	}
}