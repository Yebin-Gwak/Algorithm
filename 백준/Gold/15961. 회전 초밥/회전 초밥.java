import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		int[] count = new int[D + 1];
		
		count[C] = 1;
		int now = 1;
		
		for(int i = 0; i < K; i++) {
			int key = arr[i];
			if(count[key] == 0) 
				now++;
			count[key]++;
		}
		
		int max = now;
			
		
		for(int i = 1; i < N; i++) {
			int left = arr[i - 1];
			int right = arr[(i + K - 1) % N];
			
			// 다음값 더해주고
			if(count[right] == 0) 
				now++;
			count[right]++;
			
			// 이전값 지워주기
			
			count[left]--;
			if(count[left] == 0) 
				now--;

			max = Math.max(max, now);
		}
		System.out.println(max);
		
	}

}