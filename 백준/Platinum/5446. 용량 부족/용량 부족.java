import java.util.*;
import java.io.*;

public class Main {

	static class Node {
		HashMap<Character, Node> next = new HashMap<>();
		boolean isProtect = false;
	}

	static class Trie {
		Node root = new Node();
		ArrayList<String> removeFileList = new ArrayList<>();

		public void insertRemoveFile(String s) {
			removeFileList.add(s);
			Node now = root;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				now.next.putIfAbsent(c, new Node());
				now = now.next.get(c);
			}
		}

		public void insertProtectFile(String s) {
			Node now = root;
			now.isProtect = true;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				now.next.putIfAbsent(c, new Node());
				now = now.next.get(c);
				now.isProtect = true;
			}
		}
		
		public int remove() {
			int count = 0;
			for(String s : removeFileList) {
				count += removeFile(root, 0, s);
			}
			return count;
		}

		private int removeFile(Node now, int idx, String s) {
			char c = s.charAt(idx);
			if (!now.next.containsKey(c)) {
				return 0;
			}
			
			if (!now.isProtect) {
				now.next.clear();
				return 1;
			}
			
			if(!now.next.get(c).isProtect) {
				now.next.remove(c);
				return 1;
			}
			
			if(idx + 1 == s.length()) {
				return 1;
			}

			return removeFile(now.next.get(c), idx + 1, s);

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		Trie trie;

		for (int tc = 0; tc < T; tc++) {
			trie = new Trie();
			int N = Integer.parseInt(br.readLine());

			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				trie.insertRemoveFile(s);
			}

			int M = Integer.parseInt(br.readLine());
			for (int i = 0; i < M; i++) {
				trie.insertProtectFile(br.readLine());
			}

			int ans = trie.remove();

			sb.append(ans).append("\n");

		}
		System.out.print(sb.toString());

	}

}