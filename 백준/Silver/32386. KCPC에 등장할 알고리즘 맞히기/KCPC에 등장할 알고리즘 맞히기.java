import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int M = Integer.parseInt(st.nextToken());
			for(int j = 0; j < M; j++) {
				String t = st.nextToken();
				map.put(t, map.getOrDefault(t, 0) + 1);
			}
		}
		
		int max = 0;
		boolean isDuplicate = false;
		String ans = "";
		for(Map.Entry<String, Integer> e : map.entrySet()) {
			if(e.getValue() == max) {
				isDuplicate = true;
				continue;
			}
			if(e.getValue() > max) {
				max = e.getValue();
				isDuplicate = false;
				ans = e.getKey();
			}
		}
		
		if(isDuplicate)
			System.out.println(-1);
		else
			System.out.println(ans);
	}
}