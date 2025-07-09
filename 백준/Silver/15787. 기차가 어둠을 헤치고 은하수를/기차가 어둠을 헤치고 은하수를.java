
import java.util.*;
import java.io.*;

public class Main {
	
	static class Train{
		int b = 0;
		
		void add(int n) {
			b |= 1 << n;
		}
		
		void remove(int n) {
			b &= ~(1 << n);
		}
		
		void left() {
			b <<= 1;
			b = get();
		}
		
		void right() {
			b >>= 1;
			b = get();
		}
		
		int get() {
			return b &= ((1 << 20) - 1) << 1;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Train[] trains = new Train[N + 1];
		for(int i = 1; i <= N; i++)
			trains[i] = new Train();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			if(cmd == 1)
				trains[t].add(Integer.parseInt(st.nextToken()));
			else if(cmd == 2)
				trains[t].remove(Integer.parseInt(st.nextToken()));
			else if(cmd == 3)
				trains[t].left();
			else if(cmd == 4)
				trains[t].right();
			
		}
		HashSet<Integer> set = new HashSet<>();
		for(int i = 1; i <= N; i++)
			set.add(trains[i].get());
		
		System.out.println(set.size());
		
	}
}
