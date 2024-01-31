import java.util.*;
import java.io.*;
 
public class Solution {
    static char[][] map;
    static int turn;
    static int x, y;
    static char[] way = {'^', 'v', '<', '>'};
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int t = Integer.parseInt(br.readLine());
         
        for (int test_case = 1; test_case <= t; test_case++) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            map = new char[H+2][W+2];
 
            for (int i = 1; i < H+1; i++) {
                String mapData = br.readLine();
                for (int j = 1; j < W+1; j++) {
                    map[i][j] = mapData.charAt(j-1);
                    if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
                        x = i;
                        y = j;
                        if (map[i][j] == '^') turn = 0;
                        else if(map[i][j] == 'v') turn = 1;
                        else if(map[i][j] == '<') turn = 2;
                        else if(map[i][j] == '>') turn = 3;
                    }
                }
            }
             
            int count = Integer.parseInt(br.readLine());
            String cmd = br.readLine();
             
            for(int i = 0; i < count; i++) {
                if(cmd.charAt(i) == 'S')
                    shoot();
                else
                    move(cmd.charAt(i));
            }
             
            sb.append("#" + test_case + " ");
            for(int i = 1; i <= H; i++) {
                for(int j = 1; j <= W; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            System.out.print(sb.toString());
        }
    }
     
    private static void move(char c) {
        
        if(c == 'U') turn = 0;
        else if (c == 'D') turn = 1;
        else if (c == 'L') turn = 2;
        else if (c == 'R') turn = 3;
    	
        int nx = x + dx[turn];
        int ny = y + dy[turn];
         
        if(map[nx][ny] != 0 && map[nx][ny] == '.') {
            map[x][y] = '.';
            x = nx;
            y = ny;
            map[x][y] = way[turn];
        }
        else map[x][y] = way[turn];
    }
     
    private static void shoot() {
        int nx = x;
        int ny = y;
        while(true) {
            nx += dx[turn];
            ny += dy[turn];
            if(map[nx][ny] == '#' || map[nx][ny] == 0)
                break;
 
            if(map[nx][ny] == '*') {
                map[nx][ny] = '.';
                break;
            }
        }
    }
}