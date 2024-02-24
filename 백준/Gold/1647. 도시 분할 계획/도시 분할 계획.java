import java.util.*;
import java.io.*;

public class Main {
	static class Edge implements Comparable<Edge>{
		int from ,to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int N, M;
	static Edge[] edgeList;
	static int[] parents;
	
	static int[] input;
	static Deque<int[]> inputs = new ArrayDeque<int[]>();
	
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int[N + 1];
		edgeList = new Edge[M];
		
		input = new int[N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}
		
		Arrays.sort(edgeList);
        
		make();
		
		int cnt = 0;
        int ans = 0;
        
		for(Edge edge : edgeList) {
			if(!union(edge.from, edge.to)) continue;
			cnt++;
			ans += edge.weight;
			if(cnt == N - 1) {
				ans -= edge.weight;
				break;
			}
		}
		
		System.out.println(ans);
		
	}

	private static void make() {
		for(int i = 1; i <= N; i++)
			parents[i] = i;
		
	}
	
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;

	}

}