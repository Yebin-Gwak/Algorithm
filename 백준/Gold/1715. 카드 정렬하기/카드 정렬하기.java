import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
		for(int i = 0; i < N; i++)
			pq.add(Integer.parseInt(br.readLine()));
		
		if(N == 1) {
			System.out.println(0);
			return;
		}
		
		int ans = pq.poll() + pq.poll();
		pq.add(ans);
		
		for(int i = 0; i < N - 2; i++) {
			int n = pq.poll() + pq.poll();
			ans += n;
			pq.add(n);

		}

		System.out.println(ans);
		
	}

}