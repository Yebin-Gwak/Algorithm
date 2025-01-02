import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        return bfs(x, y, n);
    }
    
    private static int bfs(int x, int y, int n){
        boolean[] visited = new boolean[1000002];
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{x, 0});
        
        
        while(!deque.isEmpty()){
            int[] now = deque.poll();
            if(now[0] == y){
                return now[1];
            }
            
            if(now[0] + n <= 1000000 && !visited[now[0] + n]){
                visited[now[0] + n] = true;
                deque.add(new int[]{now[0] + n, now[1] + 1});
            } 
            if(now[0] * 2 <= 1000000 && !visited[now[0] * 2]){
                visited[now[0] * 2] = true;
                deque.add(new int[]{now[0] * 2, now[1] + 1});
            }
            if(now[0] * 3 <= 1000000 && !visited[now[0] * 3]){
                visited[now[0] * 3] = true;
                deque.add(new int[]{now[0] * 3, now[1] + 1});
            }
            
        }
        return -1;
    }
}