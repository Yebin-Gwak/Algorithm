import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int numbers[];
	static int input[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[N];
		input = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			numbers[i] = Integer.parseInt(st.nextToken());
		
		numbers = Arrays.stream(numbers).distinct().toArray();
		Arrays.sort(numbers);
		N = numbers.length;
		
		permutation(0, 0);
		
		System.out.print(sb.toString());
	}

	private static void permutation(int start, int cnt) {
		if(cnt == M) {
			for(int x : input)
				sb.append(x + " ");
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < N; i++) {
			input[cnt] = numbers[i];
			permutation(i, cnt + 1);
		}
		
	}

}