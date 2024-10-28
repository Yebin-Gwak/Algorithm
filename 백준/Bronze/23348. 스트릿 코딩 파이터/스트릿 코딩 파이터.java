import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int T = sc.nextInt();
		int ans = 0;
		for(int i = 0; i < T; i++) {
			int sum = 0;
			for(int j = 0; j < 3; j++) {
				int fi = sc.nextInt();
				int se = sc.nextInt();
				int th = sc.nextInt();
				sum += a * fi + b * se + c * th;
				ans = Math.max(ans, sum);
			}
		}
		System.out.println(ans);
	}
}