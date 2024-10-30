import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N + 1];
		for(int i = 1; i <= N; i++)
			arr[i] = i;
		
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int to = sc.nextInt();
			arr[a] = to;
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.println(arr[i]);
		}
	}
}