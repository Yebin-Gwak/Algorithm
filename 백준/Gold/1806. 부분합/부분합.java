import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		arr[N] = Integer.MAX_VALUE;
		
		int start = 0;
		int end = 0;
		long sum = arr[0];
		int ans = Integer.MAX_VALUE;
		
		while(true) {
			if(start == N || end == N)
				break;
			if(sum > Integer.MAX_VALUE)
				break;
			if(sum < S) 
				sum += arr[++end];
			else if(sum >= S) {
				ans = Math.min(end - start + 1, ans);
				sum -= arr[start++];
			}
		}
		
		System.out.println((ans == Integer.MAX_VALUE) ? 0 : ans);
		
		
	}
}