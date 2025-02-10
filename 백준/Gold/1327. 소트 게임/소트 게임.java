import java.util.*;
import java.io.*;

public class Main {

	static int N, K;
	static int[] arr;
	static HashSet<Integer> visited = new HashSet<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(getValue()));
		
	}

	private static int bfs(int start) {
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		visited.add(start);
		deque.add(start);
		
		int ans = 0;
		
		while(!deque.isEmpty()) {
			int size = deque.size();
			for(int i = 0; i < size; i++) {
				int now = deque.poll();
				if(isSort(now))
					return ans;
				
				for(int j = 0; j < N - K + 1; j++) {
					int next = reverse(now, j);
					if(visited.contains(next))
						continue;
					visited.add(next);
					deque.add(next);
				}
			}
			ans++;
		}
		
		return -1;
	}
	
	private static int reverse(int now, int start) {
		String s = Integer.toString(now);
		for(int i = 0; i < start; i++)
			arr[i] = s.charAt(i) - '0';
		
		for(int i = 0; i < K; i++) 
			arr[i + start] = s.charAt(start + (K - 1) - i) - '0';
		
		for(int i = start + K; i < s.length(); i++)
			arr[i] = s.charAt(i) - '0';
		
		return getValue();
	}

	private static int getValue() {
		int sum = 0;
		for(int n : arr) {
			sum = sum * 10 + n;
		}
		return sum;
	}
	
	private static boolean isSort(int value) {
		int before = 0;
		int div = (int) Math.pow(10, N - 1);
		for(int i = 0; i < N; i++) {
			if(value / div < before)
				return false;
			before = value / div;
			value %= div;
			div /= 10;
		}
		return true;
	}

}