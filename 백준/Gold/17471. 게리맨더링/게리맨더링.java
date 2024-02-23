import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static List<Integer>[] arr;
	static int[] sizes;
	static boolean[] visited;

	static int[] input;
	static Deque<int[]> inputs = new ArrayDeque<int[]>();
	static int[] numbers;
	static boolean hasAnswer = false;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N];
		sizes = new int[N];
		
		visited = new boolean[N];

		input = new int[N];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < N; i++) {
			sizes[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			for(int j = 0; j < size; j++) {
				int value = Integer.parseInt(st.nextToken()) - 1;
				arr[i].add(value);
			}
		}
		
		allPermutation(0);
		
		// 모두 0, 모두 1인 경우의 수 제거
		inputs.pollFirst();
		inputs.pollLast();
		
		int half = inputs.size() / 2;
		for(int i = 0; i < half; i++)
			bfs();
		
		if(hasAnswer)
			System.out.println(ans);
		else
			System.out.println("-1");
	}
	
	private static void bfs() {
		int[] temp = inputs.poll();
		boolean[] visited = new boolean[N];
		
		List<Integer> graphA = new ArrayList<Integer>();
		List<Integer> graphB = new ArrayList<Integer>();
		
		int sizeA = 0;
		int sizeB = 0;
		
		for(int i = 0; i < N; i++) {
			if(temp[i] == 0) graphA.add(i);
			else
				graphB.add(i);
		}
		
		Deque<Integer> deque = new ArrayDeque<Integer>();
		deque.add(graphA.get(0));
		visited[graphA.get(0)] = true;
		
		while(!deque.isEmpty()) {
			int now = deque.poll();
			sizeA += sizes[now];
			
			List<Integer> tempArr = arr[now];
			for(int i = 0; i < tempArr.size(); i++) {
				int v = tempArr.get(i);
				if(graphA.contains(v) && !visited[v]){
					visited[v] = true;
					deque.add(v);
				}
			}
		}
		
		deque = new ArrayDeque<Integer>();
		deque.add(graphB.get(0));
		visited[graphB.get(0)] = true;
		
		while(!deque.isEmpty()) {
			int now = deque.poll();
			sizeB += sizes[now];
			
			List<Integer> tempArr = arr[now];
			for(int i = 0; i < tempArr.size(); i++) {
				int v = tempArr.get(i);
				if(graphB.contains(v) && !visited[v]){
					visited[v] = true;
					deque.add(v);
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) return;
		}
		
		hasAnswer = true;
		int tempResult = Math.abs(sizeA - sizeB);
		ans = Math.min(ans, tempResult);
		
		
		
	}
	
	private static void allPermutation(int cnt) {
		if(cnt == N) {
			inputs.add(input.clone());
			return;
		}
		// 0 or 1의 경우의 수의 N승
		for(int i = 0; i <= 1; i++) {
				input[cnt] = i;
				allPermutation(cnt + 1);

		}
	}
	

}
