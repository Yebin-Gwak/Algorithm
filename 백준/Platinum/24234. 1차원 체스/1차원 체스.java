import java.util.*;
import java.io.*;

public class Main {
	
	static class Node{
		HashMap<Integer, Node> next = new HashMap<>();
		int v;
		long count = 0;
	}
	
	static class Trie{
		Node root = new Node();
		long[] ans = new long[10001];
		
		void insert(StringTokenizer st) {
			int N = Integer.parseInt(st.nextToken());
			Node now = root;
			now.count++;
			for(int i = 0; i < N; i++) {
				int v = Integer.parseInt(st.nextToken());
				now.next.putIfAbsent(v, new Node());
				now = now.next.get(v);
				now.v = v;
				now.count++;
			}
		}

		public long find(int num) {
			return ans[num];
		}
		
		public void count() {
			for(int n : root.next.keySet()) {
				check(root.next.get(n));
			}
		}
		
		private void check(Node now) {
			if(now.next.size() > 1) {
                long sum = 0;
                long sumSq = 0;
                
				for(int n : now.next.keySet()) {
					long c = now.next.get(n).count;
                    sum += c;
                    sumSq += c * c;
				}
				ans[now.v] += (sum * sum - sumSq) / 2;
			}
			
			for(int n : now.next.keySet()) {
				check(now.next.get(n));
			}
			
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		Trie trie = new Trie();
		for(int i = 0; i < N; i++) {
			trie.insert(new StringTokenizer(br.readLine()));
		}
		
		trie.count();
		
		for(int i = 0; i < Q; i++) {
			sb.append(trie.find(Integer.parseInt(br.readLine()))).append("\n");
		}
				
		System.out.print(sb.toString());
		
	}
}