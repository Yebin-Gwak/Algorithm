import java.util.*;
import java.io.*;

public class Main {

	static int[] trees;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		trees = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			trees[i] = Integer.parseInt(st.nextToken());
		
		int min = 0;
		int max = 1000000001;
		int ans = -1;
		
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

	private static boolean binarySearch(int height) {
		long cnt = 0;
		for(int tree : trees) {
			if(height >= tree)
				continue;
			cnt += tree - height;
			if(cnt >= M)
				return true;
		}
		return false;
	}

}