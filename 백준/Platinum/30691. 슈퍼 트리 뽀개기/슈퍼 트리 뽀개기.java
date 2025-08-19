import java.io.*;
import java.util.*;

public class Main {
	
    static class Edge {
        int dest;
        long cost;
        Edge(int dest, long cost) {
        	this.dest = dest;
        	this.cost = cost;
        }
    }
    
	static class Node {
		int idx;
		long distance = 0L;
		ArrayList<Edge> childs = new ArrayList<>();
		PriorityQueue<Long> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o2, o1));

		public Node(int idx) {
			this.idx = idx;
		}

		public void calc(int parent) {
			for (Edge edge : childs) {
				if (edge.dest == parent)
					continue;
				
				Node child = nodes[edge.dest];
				child.calc(idx);
				
				child.distance += edge.cost;
				
				if(pq.size() < child.pq.size()) {
					PriorityQueue<Long> tempQ = pq;
					long tempDist = distance;
					
					pq = child.pq;
					child.pq = tempQ;
					distance = child.distance;
					child.distance = tempDist;
				}
				
				long nextDist = child.distance - distance;
				while(!child.pq.isEmpty())
					pq.add(child.pq.poll() + nextDist);
			}
			
			while(!pq.isEmpty() && pq.peek() + distance > K)
				pq.poll();
			
			pq.add(-distance);
			ans = Math.max(ans, pq.size());
		}
	}

	static long K;
	static Node[] nodes;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		nodes = new Node[N + 1];
		for (int i = 1; i <= N; i++)
			nodes[i] = new Node(i);
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			nodes[p].childs.add(new Edge(c, v));
			nodes[c].childs.add(new Edge(p, v));
		}
		nodes[1].calc(0);
		System.out.println(ans);
	}
}