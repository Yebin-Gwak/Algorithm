import java.util.*;
// 7:26
// 8:16 시초
class Solution {
    static class Node implements Comparable<Node>{
        int dest;
        int cost;
        
        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
        
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    
    static ArrayList<Node>[] nodes;
    static boolean[] taxiVisited;
    static boolean[] visited;
    static int[] distances;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        nodes = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            nodes[i] = new ArrayList<Node>();
        }
        
        taxiVisited = new boolean[n + 1];
        visited = new boolean[n + 1];
        distances = new int[n + 1];
        
        for(int[] node : fares){
            int now = node[0];
            int next = node[1];
            int cost = node[2];
            nodes[now].add(new Node(next, cost));
            nodes[next].add(new Node(now, cost));
        }
        
        int minCost = Integer.MAX_VALUE;
        
        for(int i = 1; i <= n; i++){
            int taxiCost = dijkstra(s, i);
            if(taxiCost == -1)
                continue;
            int aCost = dijkstra(i, a);
            int bCost = dijkstra(i, b);
            minCost = Math.min(minCost, taxiCost + aCost + bCost);
            
        }
        
        
        int answer = 0;
        return minCost;
    }
    
    private static int dijkstra(int start, int dest){
        Arrays.fill(visited, false);
        Arrays.fill(distances, Integer.MAX_VALUE);
        pq.clear();
        
        distances[start] = 0;
        pq.add(new Node(start, 0));
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(now.dest == dest){
                return distances[dest];
            }
            if(!visited[now.dest]){
                visited[now.dest] = true;
            }
            
            for(Node next : nodes[now.dest]){
                if(now.cost + next.cost < distances[next.dest] 
                   && !visited[next.dest]){
                    distances[next.dest] = now.cost + next.cost;
                    pq.add(new Node(next.dest, distances[next.dest]));
                }
            }
            
            
            
        }
        
        
        return -1;
        
    }
}