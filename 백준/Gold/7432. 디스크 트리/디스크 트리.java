import java.util.*;
import java.io.*;

public class Main {
	
	static class Node{
		TreeMap<String, Node> next = new TreeMap<>();
	}
	
	static class Trie{
		Node root = new Node();
		StringBuilder sb;
		
		public void insert(StringTokenizer st) {
			Node now = root;
			while(st.hasMoreTokens()) {
				String s = st.nextToken();
				now.next.putIfAbsent(s, new Node());
				now = now.next.get(s);
			}
		}
		
		public String print() {
			sb = new StringBuilder();
			recur(root, 0);
			return sb.toString().trim();
		}

		private void recur(Node node, int depth) {
			for(String s : node.next.keySet()) {
				sb.append(" ".repeat(depth) + s).append("\n");
				recur(node.next.get(s), depth + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Trie trie = new Trie();
		for(int i = 0; i < N; i++)
			trie.insert(new StringTokenizer(br.readLine(), "\\"));

		System.out.print(trie.print());
	}

}