import java.util.*;
import java.io.*;

public class Main {
	
	static class Node{
		HashMap<Character, Node> next = new HashMap<>();
		boolean isEnd = false;
	}
	
	static class Trie{
		
		Node root = new Node();
		
		public void insert(String s) {
			Node now = root;
			for(char c : s.toCharArray()) {
				now.next.putIfAbsent(c, new Node());
				now = now.next.get(c);
			}
			now.isEnd = true;
		}
		
		public int find(String s) {
			Node now = root.next.get(s.charAt(0));
			int count = 1;
			
			for(int i = 1; i < s.length(); i++) {
				if(now.next.size() > 1 || (now.next.size() == 1 && now.isEnd)) {
					count++;
				}
				now = now.next.get(s.charAt(i));
			}
			
			return count;
		}
		
	}
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	String TC;
    	int tc;
    	Trie trie;
    	while(true) {
    		TC = br.readLine();
    		if(TC == null) break;
    		tc = Integer.parseInt(TC);
    		
    		trie = new Trie();
    		String[] arr = new String[tc];
    		
    		for(int i = 0; i < tc; i++) {
    			String s = br.readLine();
    			arr[i] = s;
    			trie.insert(s);
    		}
    		
    		int count = 0;
    		for(String s : arr) {
    			count += trie.find(s);
    		}
    		
    		System.out.printf("%.2f\n", (double) count / tc);
    	}
    }
}
