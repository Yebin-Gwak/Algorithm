import java.io.*;
import java.util.*;

public class Main {

	static class Trie{
		HashMap<String, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		boolean[] isFirst = new boolean[128];
		
		public void insert(String s) {
			sb.setLength(0);
			Arrays.fill(isFirst, true);
			for(int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if(!isFirst[c])
					continue;
				isFirst[c] = false;
				sb.append(c).append(i);
			}
			String key = sb.toString();
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		public int find(String s) {
			sb.setLength(0);
			Arrays.fill(isFirst, true);
			int cnt = 0;
			
			for(int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if(!isFirst[c])
					continue;
				isFirst[c] = false;
				sb.append(c).append(i);
				String key = sb.toString();
				cnt += map.getOrDefault(key, 0);
			}
			
			return cnt;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Trie trie = new Trie();
		
		for(int i = 0; i < N; i++)
			trie.insert(br.readLine());
		
		for(int i = 0; i < M; i++)
			sb.append(trie.find(br.readLine())).append("\n");
		
		System.out.print(sb.toString());
	}

}
