import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> plus = new PriorityQueue<>((o1, o2) -> o2 - o1);
		PriorityQueue<Integer> minus = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		
		int ans = 0;
		boolean hasZero = false;
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n == 1) {
				ans++;
				continue;
			}
			if(n > 0) plus.add(n);
			if(n == 0) hasZero = true;
			if(n < 0) minus.add(n);
		}
		
		while(plus.size() > 1)
			ans += plus.poll() * plus.poll();
		ans += (plus.isEmpty()) ? 0 : plus.poll();
		
		while(minus.size() > 1) 
			ans += minus.poll() * minus.poll();
		ans += (minus.isEmpty() || hasZero) ? 0 : minus.poll();
		
		System.out.println(ans);
	}
}