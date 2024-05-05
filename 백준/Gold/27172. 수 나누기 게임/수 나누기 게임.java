import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] ans = new int[1000001];
		boolean[] visited = new boolean[1000001];
		List<Integer> list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int v = Integer.parseInt(st.nextToken());
			visited[v] = true;
			list.add(v);
		}
		for(int n : list) {
			for(int i = n * 2; i < 1000001; i += n) {
				if(visited[i]) {
					ans[n]++;
					ans[i]--;
				}
			}
		}
		for(int n : list)
			sb.append(ans[n] + " ");
		
		System.out.println(sb.toString().trim());
		
	}
}