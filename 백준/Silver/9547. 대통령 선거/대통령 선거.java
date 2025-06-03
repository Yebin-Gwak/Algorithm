import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int C = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			int[][] prefers = new int[V][C];
			int[][] votes = new int[C + 1][2];
			for(int i = 1; i <= C; i++)
				votes[i][0] = i;
			
			for(int i = 0; i < V; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < C; j++)
					prefers[i][j] = Integer.parseInt(st.nextToken());
				votes[prefers[i][0]][1]++;
			}
			
			Arrays.sort(votes, ((o1, o2) -> o2[1] - o1[1]));
			if(votes[0][1] > V / 2) {
				sb.append(votes[0][0] + " " + 1).append("\n");
				continue;
			}
			int c1 = votes[0][0];
			int c2 = votes[1][0];
			int v1 = 0;
			int v2 = 0;
			
			for(int i = 0; i < V; i++) {
				for(int j = 0; j < C; j++) {
					int v = prefers[i][j];
					if(v != c1 && v != c2) continue;
					if(v == c1) v1++;
					else v2++;
					break;
				}
			}
			sb.append(((v1 > v2) ? c1 : c2) + " " + 2).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
}