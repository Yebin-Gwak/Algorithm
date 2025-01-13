public class UserSolution {
	static class Node{
		Node[] next = new Node[26];
		int count = 0;
	}
	
	Node root = new Node();
	
	public void init() {
		root = new Node();
	}
	
	public void insert(int buffer_size, String buf) {	
		Node now = this.root;
		for(int i = 0; i < buffer_size; i++) {
			int n = buf.charAt(i) - 'a';
			if(now.next[n] == null) {
				now.next[n] = new Node();
			}
			now = now.next[n];
			now.count++;
		}
	}
	
	public int query(int buffer_size, String buf) {
		return check(this.root, 0, buf);
	}
	
	private int check(Node now, int idx, String s) {
		if(idx == s.length()) {
			return now.count;
		}
		int n = s.charAt(idx) - 'a';
		
		if(now.next[n] == null) {
			return 0;
		}
		
		return check(now.next[n], idx + 1, s);
	}
}