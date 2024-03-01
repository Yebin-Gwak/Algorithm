import java.util.*;
import java.io.*;

public class Main {

	static int[][] map = new int[10][10];
	static int[] sizes = { 1, 2, 3, 4, 5 };
	static int[] papers = { 0, 5, 5, 5, 5, 5 };
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, 0);

		if(ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);

	}

	private static void dfs(int x, int y, int cnt) {
		if(cnt >= ans)
			return;
		
		if(x == 0 && y == 10) {
			ans = cnt;
			return;
		}
		
		if(map[x][y] == 1) {
			for (int size = 5; size >= 1; size--) {
				if(papers[size] == 0)
					continue;
				if(measure(x, y, size)) {
					set(x, y, size);
					
					if(x == 9) dfs(0, y + 1, cnt + 1);
					else dfs(x + 1, y, cnt + 1);
					
					remove(x, y, size);
				}
				
			}
		}else {
			if(x == 9) dfs(0, y + 1, cnt);
			else dfs(x + 1, y, cnt);
		}
		
	}


	private static boolean measure(int x, int y, int size) {
		int nx;
		int ny;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				nx = x + i;
				ny = y + j;
				if (nx >= 10 || ny >= 10 || map[nx][ny] == 0) 
					return false;
				
			}
		}

		return true;

	}

	private static void set(int x, int y, int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				map[x + i][y + j] = 0;
			}
		}

		papers[size]--;
	}
	
	static void remove(int x, int y, int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				map[x + i][y + j] = 1;
			}
		}
		
		papers[size]++;
	}

}