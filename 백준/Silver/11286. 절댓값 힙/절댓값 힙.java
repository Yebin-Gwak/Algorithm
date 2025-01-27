import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			if(Math.abs(o1) == Math.abs(o2))
				return o1 - o2;
			return Math.abs(o1) - Math.abs(o2);
		});
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				sb.append((pq.isEmpty()) ? 0 : pq.poll()).append("\n");
			else
				pq.add(n);
		}
		System.out.println(sb.toString());
	}
}