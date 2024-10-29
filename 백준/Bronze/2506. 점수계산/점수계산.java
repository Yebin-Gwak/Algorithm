import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int v = 1;
		int sum = 0;
		int prev = 0;
		for(int i = 0; i < N; i++) {
			int now = sc.nextInt();
			if(now == 0) {
				prev = 0;
				continue;
			}
			if(prev == 0) {
				v = 1;
			}
			else v++;
			sum += v;
			prev = 1;
		}
		System.out.println(sum);
	}
}