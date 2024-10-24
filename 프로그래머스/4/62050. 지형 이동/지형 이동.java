import java.util.*;
// 3:20


class Solution {
    
    static class Ladder implements Comparable<Ladder>{
        int ax, ay, bx, by, cost;
        public Ladder(int ax, int ay, int bx, int by, int cost){
            this.ax = ax;
            this.ay = ay;
            this.bx = bx;
            this.by = by;
            this.cost = cost;
        }
        
        public int compareTo(Ladder o){
            return this.cost - o.cost;
        }
    }
    
    static int N;
    static int[] parents;
    
    static boolean[][] visited;
    static int[][] numbers;
    static int[][] map;
    static int height;
    
    static int idx = 0;
    
    static ArrayDeque<int[]> deque = new ArrayDeque<>();
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static PriorityQueue<Ladder> pq = new PriorityQueue<>();
    
    public int solution(int[][] land, int height2) {
        N = land.length;
        map = land;
        numbers = new int[N][N];
        height = height2;
        
        parents = new int[(N * N) + 1];
        for(int i = 1; i <= N * N; i++){
            parents[i] = i;
        }
        
        visited = new boolean[N][N];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    bfs(i, j);
                }
            }
        }
        // for(int[] m : numbers){
        //     for(int n : m){
        //         System.out.print(n);
        //     }
        //     System.out.println();
        // }
        
        int answer = 0;
        
        while(!pq.isEmpty()){
            Ladder ladder = pq.poll();
            
            if(union(numbers[ladder.ax][ladder.ay],numbers[ladder.bx][ladder.by])){
                answer += ladder.cost;
            }
        }
        
        return answer;
    }
    private void bfs(int startX, int startY){
        visited[startX][startY] = true;
        idx++;
        deque.add(new int[]{startX, startY});
        
        while(!deque.isEmpty()){
            int[] now = deque.poll();
            int x = now[0];
            int y = now[1];
            numbers[x][y] = idx;
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]){
                    int cost = Math.abs(map[x][y] - map[nx][ny]);
                    if( cost <= height){
                        visited[nx][ny] = true;
                        deque.add(new int[]{nx, ny});
                    }
                    else{
                        pq.add(new Ladder(x, y, nx, ny, cost));
                    }
                }
            }   
            
        }
        
    }
    
    private int find(int a){
        if(parents[a] == a){
            return a;
        }
        return parents[a] = find(parents[a]);
    }
    
    private boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot){
            return false;
        }
        parents[aRoot] = parents[bRoot];
        return true;
    }
    
    
    
}