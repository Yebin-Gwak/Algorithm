import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0)
				break;
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for(int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			int sum = arr[0] + arr[1] + arr[2];
			int max = sum;
			for(int i = 3; i < N; i++) {
				sum -= arr[i - 3];
				sum += arr[i];
				max = Math.max(max, sum);
			}
			sb.append(max + "\n");
		}
		
		System.out.print(sb);
		
	}
}