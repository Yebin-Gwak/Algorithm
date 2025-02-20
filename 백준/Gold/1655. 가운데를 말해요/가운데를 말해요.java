import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Integer> l = new PriorityQueue<>((o1, o2) -> o2 - o1);
		PriorityQueue<Integer> r = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		l.add(-10001);
		r.add(10001);
		
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if(i % 2 == 0)
				l.add(n);
			else
				r.add(n);
			
			if(l.peek() > r.peek()) {
				r.add(l.poll());
				l.add(r.poll());
			}
			sb.append(l.peek() + "\n");
		}
		System.out.print(sb.toString());
	}

}