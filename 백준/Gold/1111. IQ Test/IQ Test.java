import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[] arr;
	static int a, b;
	
	static HashSet<Integer> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		exceptionCheck();
		
		if(arr[0] == arr[1]) {
			a = 1;
			b = 0;
		}
		else {
			int left = arr[2] - arr[1];
			int right = arr[1] - arr[0];
			a = left / right;
			b = arr[1] - (arr[0] * a);
		}
		
		invalidCheck();
		
		System.out.println((arr[N - 1] * a) + b);
		
	}
	
	private static void exceptionCheck() {
		if(N > 2) return;
		
		if(N == 1)
			System.out.println("A");
		else{
			if(arr[0] == arr[1])
				System.out.println(arr[0]);
			else
				System.out.println("A");
		}
		
		System.exit(0);
		
	}

	private static void invalidCheck() {
		for(int i = 0; i < N - 1; i++) {
			if(arr[i + 1] != (arr[i] * a) + b) {
				System.out.println("B");
				System.exit(0);
			}
		}
		
	}

}