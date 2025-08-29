import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ans = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			int K = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < K; j++) {
				int id = Integer.parseInt(st.nextToken());
				map.put(id, map.getOrDefault(id, 0) + 1);
			}
		}
		for(int cnt : map.values()) {
			if(cnt >= M)
				ans++;
		}
		
		System.out.println(ans);
		
	}
}