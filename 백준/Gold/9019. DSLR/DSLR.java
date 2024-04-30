import java.util.*;
import java.io.*;

public class Main {
	static class Num{
		int value;
		ArrayList<Character> history;
		public Num(int value, ArrayList<Character> history) {
			this.value = value;
			this.history = history;
		}
		
	}
	static StringBuilder sb = new StringBuilder();
	static int start, end;
	static Deque<Num> deque = new ArrayDeque<>();
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			bfs(new Num(start, new ArrayList<Character>()));
		}
		System.out.print(sb.toString());
	}
	private static void bfs(Num startNum) {
		visited = new boolean[10001];
		visited[startNum.value] = true;
		deque.clear();
		deque.add(startNum);
		
		while(true) {
			Num num = deque.poll();
			if(num.value == end) {
				for(char c : num.history)
					sb.append(c);
				sb.append("\n");
				return;
			}
			operD(num);
			operS(num);
			operL(num);
			operR(num);
		}
	}
	
	private static void operD(Num num) {
		int value = (num.value * 2) % 10000;
		if(visited[value]) return;
		visited[value] = true;
		
		ArrayList<Character> list = new ArrayList<>(num.history);
		list.add('D');
		deque.add(new Num(value, list));
	}
	
	private static void operS(Num num) {
		int value = (num.value == 0) ? 9999 : num.value - 1;
		if(visited[value]) return;
		visited[value] = true;
		
		ArrayList<Character> list = new ArrayList<>(num.history);
		list.add('S');
		deque.add(new Num(value, list));
	}

	private static void operL(Num num) {
		int value = (num.value % 1000) * 10 + (num.value / 1000);

		if(visited[value]) return;
		visited[value] = true;

		ArrayList<Character> list = new ArrayList<>(num.history);
		list.add('L');
		deque.add(new Num(value, list));
	}

	private static void operR(Num num) {
		int value = (num.value % 10) * 1000 + (num.value / 10);
				
		if(visited[value]) return;
		visited[value] = true;
		
		ArrayList<Character> list = new ArrayList<>(num.history);
		list.add('R');
		deque.add(new Num(value, list));
	}

}