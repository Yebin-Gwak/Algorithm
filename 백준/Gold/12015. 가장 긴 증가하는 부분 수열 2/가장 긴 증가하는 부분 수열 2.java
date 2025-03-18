import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] arr;
	static int[] dp;
	static int idx;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		dp = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		dp[0] = arr[0];
		idx = 1;
		
		for(int i = 1; i < N; i++) {
			if(dp[idx - 1] < arr[i])
				dp[idx++] = arr[i];
			else {
				dp[binarySearch(arr[i])] = arr[i];;
			}
		}
		
		for(int i = 0; i < N; i++) {
			if(dp[i] == 0) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(N);
		
	}
	private static int binarySearch(int v) {
		int min = 0;
		int max = idx - 1;
		while(min <= max) {
			int mid = (min + max) / 2;
			if(dp[mid] < v)
				min = mid + 1;
			else
				max = mid - 1;
		}
		
		return min;
		
	}

}
