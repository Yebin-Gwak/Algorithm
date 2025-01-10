import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int min = 0;
		int max = N - 1;
		int ans = Integer.MAX_VALUE;
		
		while(min != max) {
			int sum = arr[min] + arr[max];
			if(Math.abs(sum) < Math.abs(ans)) {
				ans = sum;}
			
			if(sum < 0) {
				min++;
			}else {
				max--;
			}
		}
		System.out.println(ans);

	}
}