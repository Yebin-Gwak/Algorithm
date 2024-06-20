import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node>{
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}	
		
    }

    static int N, E;
    static ArrayList<Node>[] nodes;
    static boolean[] visited;
    static int[] distances;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[N + 1];
        distances = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) 
            nodes[i] = new ArrayList<>();
        

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodes[start].add(new Node(dest, cost));
            nodes[dest].add(new Node(start, cost));
        }
        
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        
        int route1 = 0;
        int route2 = 0;
        
        boolean checkRoute1 = true;
        boolean checkRoute2 = true;
        
        // 1 -> v1 -> v2 -> N
        dijkstra(1, v1);
        if(distances[v1] == Integer.MAX_VALUE) checkRoute1 = false;
        else {
        	route1 += distances[v1];
        	dijkstra(v1, v2);
        	if(distances[v2] == Integer.MAX_VALUE) checkRoute1 = false;
        	else {
        		route1 += distances[v2];
        		dijkstra(v2, N);
        		if(distances[N] == Integer.MAX_VALUE) checkRoute1 = false;
        		route1 += distances[N];
        	}
        }
        
        dijkstra(1, v2);
        if(distances[v2] == Integer.MAX_VALUE) checkRoute2 = false;
        else {
        	route2 += distances[v2];
        	dijkstra(v2, v1);
        	if(distances[v1] == Integer.MAX_VALUE) checkRoute2 = false;
        	else {
        		route2 += distances[v1];
        		dijkstra(v1, N);
        		if(distances[N] == Integer.MAX_VALUE) checkRoute2 = false;
        		route2 += distances[N];
        	}
        }
        

        
        if(checkRoute1 && checkRoute2)
        	System.out.println(Math.min(route1, route2));
        else if(checkRoute1)
        	System.out.println(route1);
        else if(checkRoute2)
        	System.out.println(route2);
        else
        	System.out.println(-1);
        
    }

    static void dijkstra(int start, int dest) {
        pq.clear();
        pq.add(new Node(start, 0));
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        distances[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (!visited[now.dest]) 
                visited[now.dest] = true;

            for (Node next : nodes[now.dest]) {
                if (!visited[next.dest] && distances[next.dest] > now.cost + next.cost) {
                    distances[next.dest] = now.cost + next.cost;
                    pq.add(new Node(next.dest, distances[next.dest]));
                }
            }
            if(visited[dest])
            	return;
        }
    }
}