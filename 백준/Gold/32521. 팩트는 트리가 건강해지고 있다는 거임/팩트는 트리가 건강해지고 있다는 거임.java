import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		ArrayList<Node> edges = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int sum = 0;
		
		public Node(int sum) {
			this.sum = sum;
			if(sum == 1)
				pq.add(sum);
		}
		
		public int cut(Node parent) {
			for(Node next : edges) {
				if(next == parent)
					continue;
				int cnt = next.cut(this);
				sum += cnt;
				pq.add(cnt);
			}
			
			while(sum > K) {
				sum -= pq.poll();
				ans++;
			}
			
			return sum;
		}
		
	}
	
	static Node[] trees;
	static int N, K;
	static int ans = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		trees = new Node[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++)
			trees[i] = new Node(Integer.parseInt(st.nextToken()));
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			trees[a].edges.add(trees[b]);
			trees[b].edges.add(trees[a]);
		}
		
		trees[1].cut(null);
		
		System.out.println(ans);
		
	}

}