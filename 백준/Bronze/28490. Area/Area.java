import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = 0;
		for(int i = 0; i < n; i++) {
			a = Math.max(a, sc.nextInt() * sc.nextInt());
		}
		System.out.println(a);
	}
}