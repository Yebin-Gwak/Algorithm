import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static PriorityQueue<Integer>[] pq = new PriorityQueue[12];
	static int[] hire = new int[12];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= 11; i++)
			pq[i] = new PriorityQueue<>((o1, o2) -> o2 - o1);
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			pq[p].add(v);
		}
		
		for(int i = 1; i <= 11; i++) {
			if(!pq[i].isEmpty()) {
				hire[i] = pq[i].poll();
			}
		}
		
		for(int t = 0; t < K; t++) {
			for(int i = 1; i <= 11; i++) {
				if(hire[i] == 0) continue;
				pq[i].add(hire[i] - 1);
				hire[i] = 0;
			}
			
			for(int i = 1; i <= 11; i++) {
				if(pq[i].isEmpty()) continue;
				hire[i] = pq[i].poll();
			}
		}
		
		int ans = 0;
		for(int x : hire)
			ans += x;
		
		System.out.println(ans);
		
	}
}