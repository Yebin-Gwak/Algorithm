import java.io.*;
import java.util.*;

public class Main {
	
	static class Node{
		ArrayList<Node> childs = new ArrayList<>();
		int v = 0;
		int idx;
		
		public Node(int idx) {
			this.idx = idx;
		}
		
		public void play(int sum) {
			results[idx] = sum + v;
			for(Node child : childs)
				child.play(sum + v);
		}
		
	}

	static Node[] nodes;
	static int[] results;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		nodes = new Node[N + 1];
		results = new int[N + 1];
		
		for(int i = 1; i <= N; i++)
			nodes[i] = new Node(i);
		
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		for(int i = 2; i <= N; i++)
			nodes[Integer.parseInt(st.nextToken())].childs.add(nodes[i]);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			nodes[Integer.parseInt(st.nextToken())].v += Integer.parseInt(st.nextToken());
		}
		
		nodes[1].play(0);
		for(int i = 1; i <= N; i++)
			sb.append(results[i]).append(" ");
		
		System.out.println(sb.toString().trim());
		
	}

}