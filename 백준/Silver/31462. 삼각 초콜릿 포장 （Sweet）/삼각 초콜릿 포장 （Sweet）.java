import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static char[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
        
        map = new char[N][N];
        visited = new boolean[N][N];
        
        for(int i= 0; i < N; i++) {
        	String data = br.readLine();
        	for(int j = 0; j <= i; j++) {
        		map[i][j] = data.charAt(j);
        	}
        }
        
        for(int i= 0; i < N; i++) {
        	for(int j = 0; j <= i; j++) {
        		if(!visited[i][j]) {
        			if(!check(i, j, map[i][j])){
        				System.out.println(0);
        				return;
        			}
        			
        		}
        	}
        }
        
        System.out.println(1);
		
		
	}

	private static boolean check(int i, int j, char c) {
		if(i == N - 1)
			return false;
		if(c == 'R') {
			if(map[i + 1][j] == 'R' && map[i + 1][j + 1] == 'R' && !visited[i + 1][j] && !visited[i + 1][j + 1]) {
				visited[i][j] = true;
				visited[i + 1][j] = true;
				visited[i + 1][j + 1] = true;
				return true;
			}
			return false;
		}
		
		else if(c == 'B') {
			if(map[i][j + 1] == 'B' && map[i + 1][j + 1] == 'B' && !visited[i][j + 1] && !visited[i + 1][j + 1]) {
				visited[i][j] = true;
				visited[i][j + 1] = true;
				visited[i + 1][j + 1] = true;
				return true;
			}
			return false;
		}
		
		
		return false;
		
	}

}