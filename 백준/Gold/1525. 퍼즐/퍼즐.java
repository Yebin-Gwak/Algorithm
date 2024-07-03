import java.util.*;
import java.io.*;

public class Main {
	static HashSet<Integer> set = new HashSet<>();
	static int value = 0;
	static int answer = 123456789;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static int time = -1;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 0)
					num = 9;
				value = (value * 10) + num;
			}
		}
		
		set.add(value);
		solve();
		System.out.println(time);
		
	}
	private static void solve() {
		int[][] field = new int[3][3];
		Deque<Integer> deque = new ArrayDeque<>();
		deque.add(value);
		int now;
		int temp = 0;
		int cut = 100000000;
		int x = 0;
		int y = 0;
		int tempValue = 0;
		int sec = 0;
		
		while(!deque.isEmpty()) {
			int size = deque.size();
			for(int t = 0; t < size; t++) {
				now = deque.poll();
				if(now == answer) {
					time = sec;
					return;
				}
				cut = 100000000;
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 3; j++) {
						field[i][j] = now / cut;
						now %= cut;
						cut /= 10;
						if(field[i][j] == 9) {
							x = i;
							y = j;
						} 
					}
				}
				
				for(int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(0 <= nx && nx < 3 && 0 <= ny && ny < 3) {
						temp = field[nx][ny];
						field[nx][ny] = 9;
						field[x][y] = temp;
						
						tempValue = 0;
						for(int j = 0; j < 3; j++) {
							for(int k = 0; k < 3; k++) {
								tempValue = (tempValue * 10) + field[j][k];
							}
						}
						
						if(!set.contains(tempValue)) {
							set.add(tempValue);
							deque.add(tempValue);
						}
						
						field[nx][ny] = temp;
						field[x][y] = 9;
					}
					
					
				}
			}
			sec++;
		}
		
		
	}

}