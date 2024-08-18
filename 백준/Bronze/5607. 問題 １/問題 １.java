import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = 0;
		int b = 0;
		for(int i = 0; i < n; i++) {
			int c = sc.nextInt();
			int d = sc.nextInt();
			if(c == d) {
				a += c;
				b += d;
			}
			else if(c > d)
				a += c + d;
			else
				b += c + d;
		}
		System.out.println(a + " " + b);
	}
}