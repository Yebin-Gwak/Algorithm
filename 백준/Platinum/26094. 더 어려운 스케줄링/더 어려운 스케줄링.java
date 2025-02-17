import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		boolean reverse = false;
		
		TreeSet<Integer> set = new TreeSet<>();
		
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int v = (cmd == 0) ? Integer.parseInt(st.nextToken()) : 0;
			
			if(cmd == 0) {
				if(!reverse)
					deque.addFirst(v);
				else
					deque.addLast(v);
			}
			else if(cmd == 1) {
				while(!deque.isEmpty())
					set.add(deque.poll());
				set.remove(-1);
				reverse = false;
				if(!set.isEmpty())
					deque.add(-1);
			}
			else if(cmd == 2)
				reverse = !reverse;
			else {
				v = (!reverse) ? deque.pollFirst() : deque.pollLast();
				if(v != -1)
					sb.append(v).append("\n");
				else {
					v = (!reverse) ? set.first() : set.last();
					sb.append(v).append("\n");
					set.remove(v);
					if(!set.isEmpty()) {
						if(!reverse)
							deque.addFirst(-1);
						else
							deque.addLast(-1);
					}
				}

			}
		}
		
		System.out.print(sb.toString().trim());

	}

}