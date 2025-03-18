import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int totalCost;
	static int[] requests;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		requests = new int[N];
		st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			int v = Integer.parseInt(st.nextToken());
			requests[i] = v;
			sum += v;
		}
		
		totalCost = Integer.parseInt(br.readLine());
		if(sum <= totalCost) {
			int m = 0;
			for(int n : requests)
				m = Math.max(m, n);
			System.out.println(m);
			return;
		}
		
		int min = 0;
		int max = totalCost;
		int ans = 0;
		
		while(min <= max) {
			int mid = (min + max) / 2 + (min + max) % 2;
			if(binarySearch(mid)) {
				ans = mid;
				min = mid + 1;
			}else {
				max = mid - 1;
			}
		}
		
		System.out.println(ans);
		
	}
	private static boolean binarySearch(int limit) {
		int money = totalCost;
		for(int request : requests) {
			money -= Math.min(request, limit);
			if(money < 0)
				return false;
		}
		return true;
	}

}