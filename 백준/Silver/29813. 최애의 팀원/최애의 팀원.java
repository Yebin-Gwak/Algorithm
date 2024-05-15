import java.util.*;
import java.io.*;

public class Main {
	static class Member{
		String name;
		int count;
		public Member(String name, int count) {
			this.name = name;
			this.count = count;
		}
		
	}
	static int N;
	static Deque<Member> deque = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int count = Integer.parseInt(st.nextToken());
			deque.add(new Member(name, count));
		}
		
		play();
		
		System.out.println(deque.poll().name);
		
	}
	private static void play() {
		while(true) {
			if(deque.size() == 1) return;
			Member member = deque.poll();
			for(int i = 0; i < member.count - 1; i++) {
				deque.add(deque.pollFirst());
			}
			deque.poll();
		}	
	}
}