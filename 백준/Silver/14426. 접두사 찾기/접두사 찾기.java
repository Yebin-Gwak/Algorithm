import java.util.*;
import java.io.*;

public class Main {
	
	static class Node{
		Node[] next = new Node[26];
	}
	
	static class Trie{
		private Node root = new Node();
		
		public void insert(String s) {
			Node now = this.root;
			for(int i = 0; i < s.length(); i++) {
				int n = s.charAt(i) - 'a';
				if(now.next[n] == null) {
					now.next[n] = new Node();					
				}
				now = now.next[n];
			}
		}

		public boolean isPrefix(String s) {
			return check(this.root, 0, s);
		}
		
		private boolean check(Node node, int idx, String s) {
			if(idx == s.length()) 
				return true;
			if(node.next[s.charAt(idx) - 'a'] == null) 
				return false;

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
			trie.insert(br.readLine());
		}
		
		int count = 0;
		for(int i = 0; i < M; i++) {
			if(trie.isPrefix(br.readLine())) {
				count++;
			}
		}

		System.out.println(count);
	}

}