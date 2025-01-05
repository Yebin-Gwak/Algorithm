import java.util.*;
import java.io.*;

public class Main {
	
	static class Node{
		TreeMap<String, Node> next = new TreeMap<>();
	}
	
	static class Trie{
		StringBuilder sb;
		Node root = new Node();
		
		void insert(StringTokenizer st){
			int N = Integer.parseInt(st.nextToken());
			Node now = this.root;
			for(int j = 0; j < N; j++) {
				String s = st.nextToken();
				now.next.putIfAbsent(s, new Node());
				now = now.next.get(s);
			}
		}
		
		public String toString() {
			sb = new StringBuilder();
			print(0, root.next);
			return sb.toString();
		}
		
		public void print(int depth, TreeMap<String, Node> node) {
			for(String s : node.keySet()) {
				sb.append("--".repeat(depth) + s).append("\n");
				print(depth + 1, node.get(s).next);
			}
		}
		
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		Trie trie = new Trie();
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			trie.insert(new StringTokenizer(br.readLine()));			
		}
		
		System.out.println(trie.toString());
	}

}