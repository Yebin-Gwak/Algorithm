import java.util.*;
import java.io.*;

public class Main {

	static int[] wait = new int[26];
	static ArrayList<Integer>[] lists = new ArrayList[26];
	static int[] costs = new int[26];
	static int[] ans = new int[26];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for(int i = 0; i < 26; i++) {
			wait[i] = -1;
			lists[i] = new ArrayList<>();
		}
		
		String line = "";
		while(true) {
			line = br.readLine();
			if(line == null)
				break;

			st = new StringTokenizer(line);
			
			int v = st.nextToken().charAt(0) - 'A';
			int cost = Integer.parseInt(st.nextToken());
			wait[v]++;
			costs[v] = cost;
			
			if(st.hasMoreTokens()) {
				String s = st.nextToken();
				for(int i = 0; i < s.length(); i++) {
					int c = s.charAt(i) - 'A';
					wait[v]++;
					lists[c].add(v);
				}
			}
		}
		
		for(int i = 0; i < 26; i++)
			ans[i] = costs[i];
		System.out.println(topologySort());
		
	}

	private static int topologySort() {
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		for(int i = 0; i < 26; i++) {
			if(wait[i] == 0)
				deque.add(i);
		}
		
		while(!deque.isEmpty()) {
			int now = deque.poll();
			
			for(int next : lists[now]) {
				ans[next] = Math.max(ans[next], ans[now] + costs[next]);
				if(--wait[next] == 0)
					deque.add(next);
			}
		}
		
		int result = 0;
		for(int n : ans)
			result = Math.max(result, n); 
		return result;
	}

}