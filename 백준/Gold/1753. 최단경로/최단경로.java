import java.util.*;
import java.io.*;

public class Main {
    static class Node{
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static ArrayList<Node>[] nodes;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        nodes = new ArrayList[V + 1];
        distance = new int[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            nodes[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodes[now].add(new Node(dest, cost));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
        	if(distance[i] == Integer.MAX_VALUE)
        		System.out.println("INF");
        	else
        		System.out.println(distance[i]);
        }
    }

    static void dijkstra(int start) {
    	// Comparator 사용하여 비용 낮은 순으로 우선순위 설정
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        pq.add(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (!visited[now.v]) 
                visited[now.v] = true;

            for (Node next : nodes[now.v]) {
                if (!visited[next.v] && distance[next.v] > now.cost + next.cost) {
                    distance[next.v] = now.cost + next.cost;
                    pq.add(new Node(next.v, distance[next.v]));
                }
            }
        }
    }
}