import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[] arr;
	static int[][] cmd;
	static HashMap<Integer, Integer> visited = new HashMap<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int v = Integer.parseInt(st.nextToken());
			arr[i] = (v == 10) ? 0 : v;
		}
		
		M = Integer.parseInt(br.readLine());
		cmd = new int[M][3];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			cmd[i][0] = Integer.parseInt(st.nextToken()) - 1;
			cmd[i][1] = Integer.parseInt(st.nextToken()) - 1;
			cmd[i][2] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(dijkstra(getValue()));
		
	}

	private static int dijkstra(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.add(new int[] {start, 0});
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			
			if(isSort(now[0]))
				return now[1];
			
			if(visited.containsKey(now[0]))
				continue;
			visited.put(now[0], now[1]);
			
			for(int i = 0; i < M; i++) {
				int next = reverse(now[0], i);
				if(!visited.containsKey(next)) {
					pq.add(new int[] {next, now[1] + cmd[i][2]});
				}
			}
		}
		return -1;
	}
	
	private static int reverse(int now, int idx) {
		String s = Integer.toString(now);
		for(int i = 1; i < s.length(); i++)
			arr[i - 1] = s.charAt(i) - '0';
		
		int a = cmd[idx][0];
		int b = cmd[idx][1];
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		
		return getValue();
	}

	private static int getValue() {
		int sum = 1;
		for(int n : arr)
			sum = sum * 10 + n;
		
		return sum;
	}
	
	private static boolean isSort(int value) {
		int before = 0;
		int div = (int) Math.pow(10, N - 1);
		value %= div * 10;
		for(int i = 0; i < N; i++) {
			int next = (value / div == 0) ? 10 : value / div;
			if(next < before)
				return false;
			before = next;
			value %= div;
			div /= 10;
		}
		return true;
	}

}