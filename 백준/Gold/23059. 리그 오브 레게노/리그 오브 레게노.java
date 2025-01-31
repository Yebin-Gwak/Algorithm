import java.util.*;
import java.io.*;

public class Main {
	static HashMap<String, Integer> wait = new HashMap<>();
	static HashMap<String, ArrayList<String>> lists = new HashMap<>();
	static int cnt = 0;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String before = st.nextToken();
			String after = st.nextToken();
			
			wait.putIfAbsent(before, 0);
			wait.put(after, wait.getOrDefault(after, 0) + 1);
			lists.putIfAbsent(before, new ArrayList<>());
			lists.putIfAbsent(after, new ArrayList<>());
			lists.get(before).add(after);
		}
		
		topologySort();
		
		System.out.print((cnt != lists.size()) ? -1 : sb.toString());
		
	}

	private static void topologySort() {
		PriorityQueue<String> pq = new PriorityQueue<>();
		ArrayDeque<String> deque = new ArrayDeque<>();
		for(String s : wait.keySet()) {
			if(wait.get(s) == 0)
				pq.add(s);
		}
		
		while(!pq.isEmpty()) {
			int size = pq.size();
			for(int i = 0; i < size; i++) {
				String now = pq.poll();
				cnt++;
				sb.append(now + "\n");
				for(String next : lists.get(now)) {
					wait.put(next, wait.get(next) - 1);
					if(wait.get(next) == 0)
						deque.add(next);
				}
			}
			while(!deque.isEmpty())
				pq.add(deque.poll());
		}
	}
}