import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] values = new int[26];
	static boolean[] visited = new boolean[26];
	static HashSet<Integer> set = new HashSet<>();
	static ArrayList<String> words = new ArrayList<>();
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < s.length(); j++)
				set.add(s.charAt(j) - 'A');
			words.add(s);
		}
		
		dfs(0);
		
		System.out.println(ans);
	}
	
	private static void dfs(int depth) {
		if(depth == set.size()) {
			calc();
			return;
		}
		
		for(int next : set) {
			if(visited[next])
				continue;
			visited[next] = true;
			values[next] = 9 - depth;
			dfs(depth + 1);
			visited[next] = false;
		}
		
	}
	
	private static void calc() {
		int sum = 0;
		for(String word : words) {
			int v = 0;
			for(int i = 0; i < word.length(); i++) {
				v *= 10;
				v += values[word.charAt(i) - 'A'];
			}
			sum += v;
		}
		ans = Math.max(ans, sum);
	}
}