import java.util.*;
import java.io.*;

public class Main {

	static int N, C;
	static int[] houses;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		houses = new int[N];
		for(int i = 0; i < N; i++)
			houses[i] = Integer.parseInt(br.readLine());
		Arrays.sort(houses);

		int min = 0;
		int max = houses[N - 1];
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

	private static boolean binarySearch(int len) {
		int cnt = 1;
		int before = houses[0];
		for(int i = 1; i < N; i++) {
			if(houses[i] - before >= len) {
				if(++cnt == C)
					return true;
				before = houses[i];
			}
		}
		
		return false;
		
	}

}