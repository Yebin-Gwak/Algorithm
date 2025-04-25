import java.io.*;
import java.util.*;

public class Main {

	static char[][] map;
	static int[] dx = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		map = new char[6][6];
		for(char[] m : map)
			Arrays.fill(m, '.');
		map[2][2] = map[3][3] = 'W';
		map[2][3] = map[3][2] = 'B';
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			char c = (i % 2 == 0) ? 'B' : 'W';
			map[x][y] = c;
			for(int j = 0; j < 8; j++)
				play(x, y, c, j);
		}
		
		int w = 0;
		int b = 0;
		for(char[] line : map) {
			for(char c : line) {
				if(c == 'W')
					w++;
				else if(c == 'B')
					b++;
			}
		}
		
		for(char[] line : map) {
			for(char c : line)
				sb.append(c);
			sb.append("\n");
		}
		sb.append((w > b) ? "White" : "Black");
		
		System.out.println(sb.toString());
		
	}

	private static void play(int x, int y, char c, int d) {
		int cnt = 0;
		while(true) {
			x += dx[d];
			y += dy[d];
			if(!(0 <= x && x < 6 && 0 <= y && y < 6) || map[x][y] == '.')
				return;
			if(map[x][y] == c)
				break;
			cnt++;
		}
		
		for(int i = 0; i < cnt; i++) {
			x -= dx[d];
			y -= dy[d];
			map[x][y] = c;
		}
		
	}

}
