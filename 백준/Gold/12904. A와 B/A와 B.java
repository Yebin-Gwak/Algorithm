import java.util.*;
import java.io.*;

public class Main {

	static String a;
	static String b;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		a = br.readLine();
		b = br.readLine();
		
		System.out.println(bfs());
	}

	private static int bfs() {
		ArrayDeque<String> deque = new ArrayDeque<>();
		HashSet<String> set = new HashSet<>();
		
		set.add(b);
		deque.add(b);
		
		while(!deque.isEmpty()) {
			String now = deque.poll();
			
			if(a.equals(now))
				return 1;
			if(now.length() == 1)
				continue;
			
			String next = now.substring(0, now.length() - 1);
			if(now.charAt(now.length() - 1) == 'B')
				next = new StringBuilder().append(next).reverse().toString();
			if(set.contains(next))
				continue;
			
			set.add(next);
			deque.add(next);
		}
		
		return 0;
	}

}