import java.util.*;
import java.io.*;

public class Main {
	static class Num{
		int num, idx;

		public Num(int num, int idx) {
			this.num = num;
			this.idx = idx;
		}
	
	}
	static Deque<Num> deque = new ArrayDeque<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			while(!deque.isEmpty() && deque.peek().idx <= i - L) 
				deque.poll();
			
			Num now = new Num(Integer.parseInt(st.nextToken()), i);
			while(!deque.isEmpty() && deque.peekLast().num > now.num)
				deque.pollLast();
			
			deque.add(now);
			sb.append(deque.peek().num + " ");
		}

		System.out.println(sb.toString().trim());
		
	}

}