import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];

		int[] score = new int[N];
		int[] maxValue = new int[M];
		for(int i = 0; i < N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int[] x : arr)
			Arrays.sort(x);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				maxValue[j] = Math.max(maxValue[j], arr[i][j]);
			}
			
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(maxValue[j]==arr[i][j]) score[i]++;
			}
			
		}

		int maxScore = 0;
		for(int i = 0; i < N; i++)
			maxScore = Math.max(maxScore, score[i]); 
		
		for(int i = 0; i < N; i++)
			if(maxScore==score[i]) sb.append(i+1).append(" ");
		System.out.println(sb.toString());
	}
}