import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			sb.append(binarySearch(n)).append("\n");
		}
		System.out.print(sb.toString());
		
	}
	private static int binarySearch(int num) {
		int start = 0;
		int end = N - 1;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(arr[mid] == num)
				return 1;
			if(arr[mid] < num)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return 0;
	}
}