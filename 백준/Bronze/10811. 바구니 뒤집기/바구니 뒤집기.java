import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N + 1];
		for(int i = 1; i <= N; i++)
			arr[i] = i;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			int[] temp = new int[e - s + 1];
			for(int j = 0; j < e - s + 1; j++)
				temp[j] = arr[e - j];
			
			for(int j = s; j <= e; j++)
				arr[j] = temp[j - s];
			
		}
		
		for(int i = 1; i <= N; i++)
			sb.append(arr[i] + " ");
		
		System.out.println(sb.toString().trim());
		
	}

}