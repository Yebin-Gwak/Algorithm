import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int ans = 0;
		while(pq.size() != 1) {
			int sum = pq.poll() + pq.poll();
			ans += sum;
			pq.add(sum);
		}
		System.out.println(ans);
	}
}