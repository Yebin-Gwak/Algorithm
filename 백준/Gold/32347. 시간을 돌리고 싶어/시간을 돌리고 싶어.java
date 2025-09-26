import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int[] minDay = new int[N + 1];
		for(int i = N; i >= 1; i--) 
			minDay[i] = (arr[i] == 1) ? i : minDay[i + 1];
		
		int min = 1;
		int max = N;
		int ans = N;
		while(min <= max) {
			int mid = (min + max) / 2;
			if(binarySearch(mid, minDay, K)) {
				ans = mid;
				max = mid - 1;
			}else
				min = mid + 1;
		}
		
		System.out.println(ans);
		
	}
	
	private static boolean binarySearch(int T, int[] minDay, int K) {
		int day = minDay.length - 1;
		for(int i = 0; i < K; i++) {
			day = minDay[day] - T;
			if(day <= 1)
				return true;
			day = minDay[day];
		}
		return false;
	}
}