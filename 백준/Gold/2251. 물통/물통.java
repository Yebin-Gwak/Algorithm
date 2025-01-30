import java.util.*;
import java.io.*;

public class Main {
	
	static int A, B, C;
	static HashSet<Integer> set = new HashSet<>();
	static TreeSet<Integer> ans = new TreeSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		dfs(0, 0, C);
		
		for(int n : ans)
			sb.append(n + " ");
		System.out.print(sb.toString().trim());
	}

	private static void dfs(int a, int b, int c) {
		if(a == 0) {
			if(!ans.contains(c))
				ans.add(c);
		}
		
		int tempA = a;
		int tempB = b;
		int tempC = c;
		
		if(a != 0) {
			// a -> b
			if(b != B) {
				tempB += a;
				tempA = 0;
				if(tempB > B) {
					tempA = tempB - B;
					tempB = B;
				}
				if(!visited(tempA, tempB, tempC))
					dfs(tempA, tempB, tempC);
				tempA = a;
				tempB = b;
				tempC = c;
			}
			// a -> c
			if(c != C) {
				tempC += a;
				tempA = 0;
				if(tempC > C) {
					tempA = tempC - C;
					tempC = C;
				}
				if(!visited(tempA, tempB, tempC))
					dfs(tempA, tempB, tempC);
				tempA = a;
				tempB = b;
				tempC = c;
			}
		}
		
		if(b != 0) {
			// b -> a
			if(a != A) {
				tempA += b;
				tempB = 0;
				if(tempA > A) {
					tempB = tempA - A;
					tempA = A;
				}
				if(!visited(tempA, tempB, tempC))
					dfs(tempA, tempB, tempC);
				tempA = a;
				tempB = b;
				tempC = c;
			}
			// b -> c
			if(c != C) {
				tempC += b;
				tempB = 0;
				if(tempC > C) {
					tempB = tempC - C;
					tempC = C;
				}
				if(!visited(tempA, tempB, tempC))
					dfs(tempA, tempB, tempC);
				tempA = a;
				tempB = b;
				tempC = c;
			}
		}
		
		
		if(c != 0) {
			// c -> a
			if(a != A) {
				tempA += c;
				tempC = 0;
				if(tempA > A) {
					tempC = tempA - A;
					tempA = A;
				}
				if(!visited(tempA, tempB, tempC))
					dfs(tempA, tempB, tempC);
				tempA = a;
				tempB = b;
				tempC = c;
			}
			// c -> b
			if(b != B) {
				tempB += c;
				tempC = 0;
				if(tempB > B) {
					tempC = tempB - B;
					tempB = B;
				}
				if(!visited(tempA, tempB, tempC))
					dfs(tempA, tempB, tempC);
				tempA = a;
				tempB = b;
				tempC = c;
			}
		}
	}
	
	private static boolean visited(int a, int b, int c) {
		int v = 1000;
		v += a;
		v *= 1000;
		v += b;
		v *= 1000;
		v += c;
		if(set.contains(v))
			return true;
		set.add(v);
		return false;
	}
}