import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static TreeMap<String, Integer> wait = new TreeMap<>();
	static TreeMap<String, ArrayList<String>> lists = new TreeMap<>();
	static TreeMap<String, TreeSet<String>> ans = new TreeMap<>();
	static TreeSet<String> top = new TreeSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			String s = st.nextToken();
			wait.put(s, 0);
			lists.put(s, new ArrayList<>());
			ans.put(s, new TreeSet<>());
		}
		M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String before = st.nextToken();
			String after = st.nextToken();
			wait.put(before, wait.get(before) + 1);
			lists.get(after).add(before);
		}

		topologySort();
		
		sb.append(top.size()).append("\n");
		for(String s : top)
			sb.append(s + " ");
		sb.append("\n");
		for(String s : ans.keySet()) {
			sb.append(s + " ");
			sb.append(ans.get(s).size() + " ");
			for(String n : ans.get(s))
				sb.append(n + " ");
			sb.append("\n");
		}
		

		System.out.print(sb.toString().trim());
	}

	private static void topologySort() {
		ArrayDeque<String> deque = new ArrayDeque<>();
		for (String s : wait.keySet()) {
			if(wait.get(s) == 0) {
				top.add(s);
				deque.add(s);
			}
		}

		while(!deque.isEmpty()) {
			String now = deque.poll();
			for (String next : lists.get(now)) {
				wait.put(next, wait.get(next) - 1);
				if(wait.get(next) == 0) {
					ans.get(now).add(next);
					deque.add(next);
				}
			}

		}
	}
}
