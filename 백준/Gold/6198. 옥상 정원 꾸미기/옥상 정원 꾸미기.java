import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long ans = 0;
		ArrayDeque<Integer> v = new ArrayDeque<>();
		ArrayDeque<Integer> indexes = new ArrayDeque<>();
		
		for(int i = 0; i < N; i++) {
			int next = Integer.parseInt(br.readLine());
			while(!v.isEmpty() && v.peekLast() <= next) {
				v.pollLast();
				int idx = indexes.pollLast();
				ans += i - idx - 1;
			}
			v.add(next);
			indexes.add(i);
		}
		
		while(!indexes.isEmpty())
			ans += N - indexes.pollLast() - 1;

		System.out.println(ans);
	}

}