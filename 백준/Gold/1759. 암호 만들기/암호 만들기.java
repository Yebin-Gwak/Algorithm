import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static String[] chars, pw;
	static boolean[] visited;
	static int L, C; //C개중 L개 선택
	static String check = "aeiou";
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		pw = new String[L];
		visited = new boolean[C];
		
		chars = br.readLine().split(" ");
		
		Arrays.sort(chars);
		find(0, 0, 0, 0);
		System.out.println(sb.toString());
	}

	private static void find(int cnt, int idx, int a, int b) {
		if(cnt == L) {
			if(a < 1 || b < 2) return;
			for(String s : pw) {
				sb.append(s);
			}
			sb.append("\n");
			return;
		}

		for(int i = idx; i < C; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			
			pw[cnt] = chars[i];
			if(check.contains(chars[i])) find(cnt + 1, i + 1, a + 1, b);
			else find(cnt + 1, i + 1, a, b + 1);
			visited[i] = false;
		}
	}
}