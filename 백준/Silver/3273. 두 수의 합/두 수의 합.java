import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num];
		int ans = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < num-1; i++) {
			if(arr[i] > x) break;
			for(int j = i + 1; j < num; j++) {
				if(arr[i] + arr[j] > x) break;
				if(arr[i] + arr[j] == x) ans += 1;
			}
		}
		
		System.out.println(ans);

	}

}