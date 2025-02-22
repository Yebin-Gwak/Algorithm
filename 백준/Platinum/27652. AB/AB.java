import java.util.*;
import java.io.*;

public class Main {

	static class Node {
		int cnt = 0;
		Node[] next = new Node[26];
	}

	static class Trie {
		Node[] roots = new Node[] { new Node(), new Node() };
		int sum = 0;

		public void add(String s, int idx) {
			Node now = roots[idx];
			int i = (idx == 0) ? 0 : s.length() - 1;
			int end = (idx == 0) ? s.length() : -1;
			int op = (idx == 0) ? 1 : -1;
			
			for (; i != end; i += op) {
				int c = s.charAt(i) - 'a';
				if (now.next[c] == null)
					now.next[c] = new Node();
				now = now.next[c];
				now.cnt++;
			}

		}

		public void delete(String s, int idx) {
			Node now = roots[idx];
			int i = (idx == 0) ? 0 : s.length() - 1;
			int end = (idx == 0) ? s.length() : -1;
			int op = (idx == 0) ? 1 : -1;
			
			for (; i != end; i += op) {
				int c = s.charAt(i) - 'a';
				now = now.next[c];
				now.cnt--;
			}

		}

		public int find(String s) {
			sum = 0;
			findA(roots[0], s, 0);
			return sum;
		}

		public void findA(Node now, String s, int idx) {
			if (idx == s.length())
				return;
			int c = s.charAt(idx) - 'a';
			if (now.next[c] == null)
				return;
			findA(now.next[c], s, idx + 1);
			findB(roots[1], s, s.length() - 1, idx, now.next[c].cnt);
		}

		public void findB(Node now, String s, int idx, int aIdx, int aCnt) {
			if (idx == aIdx) {
				sum += aCnt * now.cnt;
				return;
			}
			int c = s.charAt(idx) - 'a';
			if (now.next[c] == null)
				return;
			findB(now.next[c], s, idx - 1, aIdx, aCnt);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		Trie trie = new Trie();
		int Q = Integer.parseInt(br.readLine());
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			
			if(c == 'f') {
				sb.append(trie.find(st.nextToken())).append("\n");
				continue;
			}
			
			int idx = st.nextToken().charAt(0) - 'A';
			String s = st.nextToken();
			
			if (c == 'a')
				trie.add(s, idx);
			else
				trie.delete(s, idx);
		}

		System.out.print(sb.toString());

	}

}