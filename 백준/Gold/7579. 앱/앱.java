import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] wArr = new int[N];
		int[] vArr = new int[N];
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			vArr[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			wArr[i] = Integer.parseInt(st.nextToken());
			max += wArr[i];
		}
		
		int[] dp = new int[max + 1];
		for(int i = 0; i < N; i++) {
			int w = wArr[i];
			int v = vArr[i];
			for(int j = max; j >= w; j--)
				dp[j] = Math.max(dp[j], dp[j - w] + v);
		}
		
		for(int i = 0; i <= max; i++) {
			if(dp[i] >= M) {
				System.out.println(i);
				return;
			}
		}
		
	}
}