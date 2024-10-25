import java.util.*;
// 10:20
class Solution {
    static boolean[] visited;
    static List<Integer>[] list;    
    static int answer = 0;
    
    public int solution(int n, int[][] edge) {
        list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<Integer>();
        }
        visited = new boolean[n + 1];
        
        for(int[] e : edge){
            int start = e[0];
            int end = e[1];
            list[start].add(end);
            list[end].add(start);
        }
        
        
        return bfs();
    }
    
    private static int bfs(){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        visited[1] = true;
        deque.add(1);
        ArrayList<Integer> checker = new ArrayList<>();
        int length = 0;
        while(!deque.isEmpty()){
            length = deque.size();
            for(int i = 0; i < length; i++){
                
                int now = deque.poll();
                for(int next : list[now]){
                    if(!visited[next]){
                        visited[next] = true;
                        deque.add(next);
                    }
                }
            }
        }
        return length;
    }
}