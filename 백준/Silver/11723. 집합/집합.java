import java.util.*;
import java.io.*;

public class Main {
	
	static class BitMask{
		int b = 0;
		
		void add(int n) {
			b |= (1<<n);
		}
		
		void remove(int n) {
			b &= ~(1<<n);
		}
		
		int check(int n) {
			return ((b & (1<<n)) == 0) ? 0 : 1;
		}
		
		void toggle(int n) {
			b ^= (1<<n);
		}
		
		void all() {
			b = ((1<<20) - 1) << 1;
		}
		
		void empty() {
			b = 0;
		}
		
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		BitMask bm = new BitMask();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if(s.equals("add"))
				bm.add(Integer.parseInt(st.nextToken()));
			else if(s.equals("remove"))
				bm.remove(Integer.parseInt(st.nextToken()));
			else if(s.equals("toggle"))
				bm.toggle(Integer.parseInt(st.nextToken()));
			else if(s.equals("check"))
				sb.append(bm.check(Integer.parseInt(st.nextToken()))).append("\n");
			else if(s.equals("all"))
				bm.all();
			else if(s.equals("empty"))
				bm.empty();
		}
		
		System.out.print(sb.toString());
		
	}
}