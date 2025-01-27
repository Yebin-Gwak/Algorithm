import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		
		int ans = 0;
		int sum = 0;
		int start = 0;
		int end = N - 1;
		while(start < end) {
			sum = arr[start] + arr[end];
			if(sum < M) {
				start++;
			}else if(sum > M) {
				end--;
			}else {
				ans++;
				start++;
				end--;
			}
		}
		System.out.println(ans);
	}
}
