import java.util.*;

public class Main {
	static long A, B;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextLong();
		B = sc.nextLong();
		
		bfs();
		sc.close();

	}
	private static void bfs() {
		Deque<Long> deque = new ArrayDeque<>();
		deque.add(A);
		long ans = 0;
		long size;
		
		while(!deque.isEmpty()) {
			ans++;
			size = deque.size();

			for(long i = 0; i < size; i++) {
				long now = deque.poll();
				if (now == B){
					System.out.println(ans);
					return;
				}
				
				long x2 = now * 2;
				long addOne = Long.parseLong((Long.toString(now) + "1"));

				if(x2 <= B) deque.add(x2);
				if(addOne <= B) deque.add(addOne);
			}
			
		}
		
		System.out.println(-1);
	}

}