import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Deque<Integer> deque = new ArrayDeque<>();
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(new StringBuilder(br.readLine()).reverse().toString());
		for(int i = 1; i <= N; i++) {
			int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) 
                deque.addFirst(i);
            else if (cmd == 2) {
                int temp = deque.pollFirst();
                deque.addFirst(i);
                deque.addFirst(temp);             	
            }
            else 
                deque.addLast(i);
            
		}
		while(!deque.isEmpty())
			sb.append(deque.poll()).append(" ");
		System.out.println(sb.toString());

	}
}
