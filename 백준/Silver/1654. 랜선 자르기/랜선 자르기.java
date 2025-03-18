import java.util.*;
import java.io.*;

public class Main {

	static int N, K;
	static int[] cables;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		cables = new int[K];
		for(int i = 0; i < K; i++)
			cables[i] = Integer.parseInt(br.readLine());
		
		long min = 0;
		long max = Integer.MAX_VALUE;
		long ans = 0;

		while(min <= max) {
			long mid = (min + max) / 2 + (min + max) % 2;
			if(binarySearch(mid)) {
				ans = mid;
				min = mid + 1;
			}else {
				max = mid - 1;
			}
		}
		
		System.out.println(ans);
		
	}
	private static boolean binarySearch(long len) {
		long cnt = 0;
		for(int c : cables) {
			if(c >= len)
				cnt += c / len;
			if(cnt >= N)
				return true;
		}
		return false;
	}

}