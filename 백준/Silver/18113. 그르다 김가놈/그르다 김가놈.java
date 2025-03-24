import java.util.*;
import java.io.*;

public class Main {

	static int[] gimbaps;
	static int N, K, M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		gimbaps = new int[N];
		for(int i = 0; i < N; i++) {
			int g = Integer.parseInt(br.readLine());
			if(g <= K) 
				gimbaps[i] = 0;
			else
				gimbaps[i] = (g >= K * 2) ? g - K * 2 : g - K;
		}
		
		int ans = -1;
		
		int min = 1;
		int max = 1000000001;
		
		while(min <= max) {
			int mid = (min + max) / 2 + (min + max) % 2;
			if(binarySearch(mid)) {
				ans = mid;
				min = mid + 1;
			}else
				max = mid - 1;
		}
		
		System.out.println(ans);
	}

	private static boolean binarySearch(int cut) {
		long cnt = 0;
		for(int g : gimbaps) 
			cnt += g / cut;
		
		if(cnt >= M)
			return true;
		return false;
	}

}