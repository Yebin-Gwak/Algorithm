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

		int[] ans = new int[N];
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			while(!left.isEmpty() && left.peekLast()[1] < n) 
				ans[left.pollLast()[0]] = n;

			left.addLast(new int[] {i, n});
		}
		
		while(!left.isEmpty())
			ans[left.poll()[0]] = -1;
		
		for(int n : ans) 
			sb.append(n + " ");
		
		System.out.print(sb.toString().trim());
	}
}