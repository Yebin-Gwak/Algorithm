import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<int[]> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new int[] {x, y});
		}
		
		Collections.sort(list, (o1, o2) -> {
			if(o1[0] == o2[0])
				return o1[1] - o2[1];
			return o1[0] - o2[0];
		});
		
		int ans = 0;
		int[] now = list.get(0);
		for(int i = 1; i < list.size(); i++) {
			int[] next = list.get(i);
			if(next[0] > now[1]) {
				ans += now[1] - now[0];
				now = next;
				continue;
			}
			
			now[1] = Math.max(now[1], next[1]);
			
		}
		ans += now[1] - now[0];
		
		System.out.println(ans);
		
	}

}