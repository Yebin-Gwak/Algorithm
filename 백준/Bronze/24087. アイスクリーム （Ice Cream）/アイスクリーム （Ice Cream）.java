import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(s <= a) {
			System.out.println(250);
			return;
		}
		else {
			s -= a;
			int c = s / b * 100;
			int d = (s % b != 0) ? 100 : 0;
			System.out.println(250 + c + d);
		}
	}
}