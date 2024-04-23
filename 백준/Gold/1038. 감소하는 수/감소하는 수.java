import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static ArrayList<Long> list = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		list.add((long) 0);
		for(long i = 1; i <= 9; i++) 
			dfs(i);

		if(list.size() <= N) {
			System.out.println(-1);
			return;
		}
		
		Collections.sort(list);
		System.out.println(list.get(N));
	}
	private static void dfs(long num) {
		list.add(num);
		
		long last = num % 10;
		for(long i = 0; i < last; i++) 
			dfs(num * 10 + i);
	}

}