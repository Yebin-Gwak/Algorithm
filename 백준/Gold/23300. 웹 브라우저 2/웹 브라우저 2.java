import java.io.*;
import java.util.*;

public class Main {
	static Deque<Integer> back = new ArrayDeque<>();
	static Deque<Integer> front = new ArrayDeque<>();
	static int N, Q;
	static int now = -1;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			char cmd = st.nextToken().charAt(0);
			if(cmd == 'B')
				goBack();
			else if(cmd == 'F')
				goFront();
			else if(cmd == 'C')
				compress();
			else if(cmd == 'A')
				access(Integer.parseInt(st.nextToken()));
		}
		
		System.out.println(now);
		
		if(back.isEmpty())
			System.out.println(-1);
		else {
			while(!back.isEmpty())
				sb.append(back.pollLast() + " ");
			System.out.println(sb.toString().trim());
		}
		
		
		if(front.isEmpty())
			System.out.println(-1);
		else {
			sb = new StringBuilder();
			while(!front.isEmpty())
				sb.append(front.pollFirst() + " ");			
			System.out.println(sb.toString().trim());
		}
		
		
	}
	
	private static void access(int page) {
		front.clear();
		if(now != -1)
			back.add(now);
		now = page;
	}

	private static void goBack() {
		if(back.isEmpty()) return;
		front.addFirst(now);
		now = back.pollLast();
	}
	
	private static void goFront() {
		if(front.isEmpty()) return;
		back.add(now);
		now = front.pollFirst();
	}


	private static void compress() {
        if (back.isEmpty()) return;
        Deque<Integer> newBack = new ArrayDeque<>();
        Integer last = -1;
        for (int page : back) {
            if (page != last) {
                newBack.add(page);
                last = page;
            }
        }
        back = newBack;
	}

}