import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	
	static int[] arr;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	
	
	//경우의 수 체크용
	static int[] operators = new int[4];
	static int[] input;
	static boolean[] visited;
	static Deque<int[]> inputs = new ArrayDeque<>();
	
	
	public static void main(String[] args) throws IOException{
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		
		operators = initOperator();
		
		input = new int[N - 1];
		visited = new boolean[N - 1];
		
		permutation(0);
		
		while(!inputs.isEmpty())
			calc();
		
		
		System.out.println(max);
		System.out.println(min);
		
	}


	private static void calc() {
		int result = arr[0];
		
		int[] temp = inputs.poll();
		
		for(int i = 0; i < temp.length; i++) {
			if(temp[i] == 0)
				result += arr[i + 1];
			else if(temp[i] == 1)
				result -= arr[i + 1];
			else if(temp[i] == 2)
				result *= arr[i + 1];
			else
				result /= arr[i + 1];
		}
		
		max = Math.max(max, result);
		min = Math.min(min, result);
		
	}


	private static void permutation(int cnt) {
		if(cnt == N - 1) {
			inputs.add(input.clone());
			return;
		}
		
		for(int i = 0; i < N - 1; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			
			input[cnt] = operators[i];
			permutation(cnt + 1);
			
			visited[i] = false;
		}
		
	}


	private static int[] initOperator() throws IOException {
		
		int[] result = new int[N - 1];
		Deque<Integer> temp = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			int count = Integer.parseInt(st.nextToken());
			for(int j = 0; j < count; j++)
				temp.add(i);
		}
		
		for(int i = 0; i < result.length; i++)
			result[i] = temp.poll();
		
		return result;
	}

}