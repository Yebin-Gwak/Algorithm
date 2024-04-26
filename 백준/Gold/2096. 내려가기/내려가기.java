import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] min = new int[N + 1][3];
		int[][] max = new int[N + 1][3];
		int[][] arr = new int[N + 1][3];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		for(int i = 0; i < 3; i++) {
			min[1][i] = arr[1][i];
			max[1][i] = arr[1][i];
		}
		
		for(int i = 1; i <= N; i++) {
			min[i][0] = Math.min(min[i - 1][0], min[i - 1][1]) + arr[i][0];
			max[i][0] = Math.max(max[i - 1][0], max[i - 1][1]) + arr[i][0];
			
			min[i][1] = Math.min(Math.min(min[i - 1][0], min[i - 1][1]), min[i - 1][2]) + arr[i][1];
			max[i][1] = Math.max(Math.max(max[i - 1][0], max[i - 1][1]), max[i - 1][2]) + arr[i][1];
			
			min[i][2] = Math.min(min[i - 1][1], min[i - 1][2]) + arr[i][2];
			max[i][2] = Math.max(max[i - 1][1], max[i - 1][2]) + arr[i][2];
		}
		
		int minV = Integer.MAX_VALUE;
		int maxV = 0;
		for(int x : min[N])
			minV = Math.min(minV, x);
		for(int x : max[N])
			maxV = Math.max(maxV, x);
		
		
		System.out.println(maxV + " " + minV);
		
	}

}