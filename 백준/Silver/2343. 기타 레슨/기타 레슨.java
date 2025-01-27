import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int M;
	static int[] arr;
	static int min = 0;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			arr[i] = n;
			min = Math.max(min, n);
			max += n;
		}
		
		System.out.println(binarySearch());
		
	}
	private static int binarySearch() {
		int start = min;
		int end = max;
		int ans = max;
		w : while(start <= end) {
			int mid = (start + end) / 2;
			int count = 1;
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if(sum + arr[i] > mid) {
					count++;
					sum = 0;
					if(count > M) {
						start = mid + 1;
						continue w;
					}
				}
				sum += arr[i];
			}
			ans = mid;
			end = mid - 1;
		}
		return ans;
	}
}