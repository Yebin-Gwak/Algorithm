import java.io.*;
import java.util.*;

public class Main {
	
	static int A, B, goalA, goalB;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		goalA = Integer.parseInt(st.nextToken());
		goalB = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs());
		
	}
	private static int bfs() {
		HashSet<Integer>[] maps = new HashSet[A + 1];
		for(int i = 0; i <= A; i++)
			maps[i] = new HashSet<>();
		
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] {0, 0});
		maps[0].add(0);
		
		int cost = 0;
		int tempA;
		int tempB;
		
		while(!dq.isEmpty()) {
			int size = dq.size();
			for(int i = 0; i < size; i++) {
				int[] now = dq.poll();
				int a = now[0];
				int b = now[1];
				
				if(a == goalA && b == goalB)
					return cost;
				
				// 물통A 풀
				if(!maps[A].contains(b)) {
					maps[A].add(b);
					dq.add(new int[] {A, b});
				}
				// 물통B 풀
				if(!maps[a].contains(B)) {
					maps[a].add(B);
					dq.add(new int[] {a, B});
				}
				
				// 물통A 버리기
				if(!maps[0].contains(b)) {
					maps[0].add(b);
					dq.add(new int[] {0, b});
				}
				
				// 물통B 버리기
				if(!maps[a].contains(0)) {
					maps[a].add(0);
					dq.add(new int[] {a, 0});
				}
				
				// 물통A B에 붓기
				tempA = Math.max(0, a - (B - b));
				tempB = Math.min(b + a, B);
				if(!maps[tempA].contains(tempB)) {
					maps[tempA].add(tempB);
					dq.add(new int[] {tempA, tempB});
				}
				// 물통B A에 붓기
				tempA = Math.min(a + b, A);
				tempB = Math.max(0, b - (A - a));
				if(!maps[tempA].contains(tempB)) {
					maps[tempA].add(tempB);
					dq.add(new int[] {tempA, tempB});
				}
				
			}
			cost++;
		}
		
		return -1;
	}

}