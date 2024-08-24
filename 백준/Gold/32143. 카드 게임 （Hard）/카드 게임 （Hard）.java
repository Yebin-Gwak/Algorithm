import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int H = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
		PriorityQueue<Integer> list = new PriorityQueue<Integer>();
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		int sum = 0;
		int count = 0;
		while(!pq.isEmpty()) {
			int n = pq.poll();
			sum += n;
			list.add(n);
			if(sum >= H)
				break;
		}
		if(sum >= H)
			sb.append(list.size()).append("\n");
		else
			sb.append(-1).append("\n");
		for(int i = 0; i < Q; i++) {
			int n = Integer.parseInt(br.readLine());
			if(sum < H) {
				sum += n;
				list.add(n);
			}
			else {
				if(n >= list.peek()) {
					sum -= list.poll();
					list.add(n);
					sum += n;
				}
			}
			while(true) {
				if(sum - list.peek() >= H)
					sum -= list.poll();
				else
					break;
			}
			if(sum >= H)
				sb.append(list.size()).append("\n");
			else
				sb.append(-1).append("\n");
		}
		System.out.print(sb.toString());
	}

}