import java.util.*;


class Solution {
    
    static int N;
    static int M;
    static int[][] map;
    
    static boolean[][] visited;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    
    static ArrayList<Integer> list = new ArrayList<>();
    
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++){
            String s = maps[i];
            for(int j = 0; j < M; j++){
                map[i][j] = (s.charAt(j) == 'X') ? -1 : s.charAt(j) - '0';
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] != -1 && !visited[i][j]){
                    visited[i][j] = true;
                    bfs(i, j);
                }
            }
        }
        
        if(list.size() == 0){
            return new int[]{-1};
        }
        
        
        Collections.sort(list);
        
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    private static void bfs(int startX, int startY){
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{startX, startY});
        int cost = 0;
        
        while(!deque.isEmpty()){
            int[] now = deque.poll();
            int x = now[0];
            int y = now[1];
            cost += map[x][y];
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] != -1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    deque.add(new int[]{nx, ny});
                }
            }
            
        }
        
        list.add(cost);
        
    }
    
    
    
}