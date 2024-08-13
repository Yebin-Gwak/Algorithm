import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a == 0 && b == 0)
				return;
			b /= a;
			int sum = 0;
			for(int i = 0; i < a; i++) {
				int c = sc.nextInt();
				sum += (c >= b) ? b : c;
			}
			System.out.println(sum);
		}
	}
}