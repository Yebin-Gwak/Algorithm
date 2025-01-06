import java.io.*;

public class Main {
	
	static class Node{
		Node[] next = new Node[10];
		boolean isEnd = false;
	}
	
	static class Trie{
		private Node root = new Node();
		
		public void insert(String s) {
			Node now = this.root;
			for(int i = 0; i < s.length(); i++) {
				int n = s.charAt(i) - '0';
				if(now.next[n] == null) {
					now.next[n] = new Node();					
				}
				now = now.next[n];
			}
			now.isEnd = true;
		}

		public boolean isDuplicate(String s) {
			return check(this.root, 0, s);
		}
		
		private boolean check(Node node, int idx, String s) {
			if(idx == s.length()) 
				return false;
			if(node.isEnd) 
				return true;

			return check(node.next[s.charAt(idx) - '0'], idx + 1, s);

		}
		
	}
		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		w : for(int tc = 0; tc < TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			Trie trie = new Trie();
			String[] arr = new String[N];
			
			for(int i = 0; i < N; i++) {
				String s = br.readLine();
				arr[i] = s;
				trie.insert(s);
			}
			
			for(int i = 0; i < N; i++) {
				if(trie.isDuplicate(arr[i])) {
					sb.append("NO").append("\n");
					continue w;
				}
			}
			sb.append("YES").append("\n");
			
		}

		System.out.println(sb.toString());
	}

}
