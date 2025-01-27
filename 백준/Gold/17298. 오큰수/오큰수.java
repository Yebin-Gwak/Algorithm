import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		ArrayDeque<int[]> left = new ArrayDeque<>();
		ArrayDeque<int[]> right = new ArrayDeque<>();
		
		for(int i = 0; i < N; i++) {
			right.add(new int[] {i, Integer.parseInt(st.nextToken())});
		}
		int[] ans = new int[N];
		while(!right.isEmpty()) {
			int r = right.peekFirst()[1];
			while(!left.isEmpty() && left.peekLast()[1] < r) 
				ans[left.pollLast()[0]] = r;

			left.addLast(right.pollFirst());
		}
		
		while(!left.isEmpty()) 
			ans[left.poll()[0]] = -1;
		
		for(int n : ans) 
			sb.append(n + " ");
		
		System.out.print(sb.toString().trim());
	}

}