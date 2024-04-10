import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int[] arr;
	static int sum, ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			ans = 0;
			calc();
			sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
		
	}

	private static void calc() {
		sum = 0;
		// 첫 케이스
		for(int i = 0; i < M; i++)
			sum += arr[i];
		if(sum < K)
			ans++;
		if(N == M)
			return;
		for(int i = 1; i < N; i++) {
			sum -= arr[i - 1];
			sum += arr[(i + M - 1) % N];
			if(sum < K)
				ans++;
		}
		
	}

}