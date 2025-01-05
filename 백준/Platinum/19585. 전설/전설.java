import java.util.*;
import java.io.*;

public class Main {
	
	static class Node{
		Node[] next = new Node[26];
		boolean isEnd = false;
	}
	
	static class Trie{
		private Node root = new Node();
		private HashSet<String> set = new HashSet<>();
		
		public void insertColor(String s) {
			Node now = this.root;
			for(int i = 0; i < s.length(); i++) {
				int n = s.charAt(i) - 'a';
				if(now.next[n] == null) {
					now.next[n] = new Node();					
				}
				now = now.next[n];
			}
			now.isEnd = true;
		}
		
		public void insertNickname(String s) {
			set.add(s);
		}
		
		public boolean checkTeam(String s) {
			return check(this.root, 0, s);
		}
		
		private boolean check(Node node, int idx, String s) {
			if(idx == s.length() - 1) 
				return false;
			if(node.next[s.charAt(idx) - 'a'] == null) 
				return false;
			
			if(node.next[s.charAt(idx) - 'a'].isEnd && set.contains(s.substring(idx + 1)))
				return true;
			return check(node.next[s.charAt(idx) - 'a'], idx + 1, s);

		}
		
	}
		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Trie trie = new Trie();
		
		for(int i = 0; i < N; i++) {
			trie.insertColor(br.readLine());			
		}
		for(int i = 0; i < M; i++) {
			trie.insertNickname(br.readLine());
		}
		
		int K = Integer.parseInt(br.readLine());
		for(int i = 0; i < K; i++) {
			sb.append((trie.checkTeam(br.readLine()) ? "Yes" : "No")).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}