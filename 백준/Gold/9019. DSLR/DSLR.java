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
	static char[] oper = {'D', 'S', 'L', 'R'};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
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
			for(int i = 0; i < 4; i++) {
				int value = calc(num.value, i);
				
				if(visited[value]) continue;
				visited[value] = true;
				
				ArrayList<Character> list = new ArrayList<>(num.history);
				list.add(oper[i]);
				deque.add(new Num(value, list));
			}
		}
	}
	
	private static int calc(int value, int oper) {
		if(oper == 0) return (value * 2) % 10000;
		if(oper == 1) return (value == 0) ? 9999 : value - 1;
		if(oper == 2) return (value % 1000) * 10 + (value / 1000);
		else return (value % 10) * 1000 + (value / 10);
	}

}