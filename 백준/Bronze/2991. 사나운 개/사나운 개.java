import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		for(int i = 0; i < 3; i++) {
			int n = sc.nextInt();
			int cnt = 0;
			if((n % (a + b) != 0) && (n % (a + b) <= a)) {
				cnt++;
			}
			
			if((n % (c + d) != 0) && (n % (c + d) <= c)) {
				cnt++;
			}
			System.out.println(cnt);
		}
	}
}