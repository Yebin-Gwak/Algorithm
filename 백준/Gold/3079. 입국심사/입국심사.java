import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		long max = Long.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.min(max, arr[i]);
		}
		
		long min = 1;
		max = max * M;
		long ans = max * M;
		while(min <= max) {
			long mid = (min + max) / 2;
			if(binarySearch(arr, mid, M)) {
				ans = mid;
				max = mid - 1;
			}else
				min = mid + 1;
		}
		
		System.out.println(ans);
	}

	private static boolean binarySearch(long[] arr, long mid, long M) {
		long sum = 0;
		for(long v : arr) {
			sum += mid / v;
			if(sum >= M)
				return true;
		}
		return false;
	}
}
