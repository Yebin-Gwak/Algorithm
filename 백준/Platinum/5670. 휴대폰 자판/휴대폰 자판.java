import java.util.*;
import java.io.*;

public class Main {
	
	static class Node{
		Node[] next = new Node[26];
		int size = 0;
		boolean isEnd = false;
	}
	
	static class Trie{
		
		Node root = new Node();
		
		public void insert(String s) {
			Node now = root;
			for(int i = 0; i < s.length(); i++) {
				int n = s.charAt(i) - 'a';
				if(now.next[n] == null) {
					now.size++;
					now.next[n] = new Node();
				}
				now = now.next[n];
			}
			now.isEnd = true;
		}
		
		public int find(String s) {
			Node now = root.next[s.charAt(0) - 'a'];
			int count = 1;
			
			for(int i = 1; i < s.length(); i++) {
				int n = s.charAt(i) - 'a';
				if(now.size > 1 || (now.size == 1 && now.isEnd)) {
					count++;
				}
				now = now.next[n];
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