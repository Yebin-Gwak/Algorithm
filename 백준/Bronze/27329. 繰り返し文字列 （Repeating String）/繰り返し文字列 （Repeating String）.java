import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		for(int i = 0; i < n / 2; i++) {
			if(s.charAt(i) != s.charAt(i + (n / 2))) {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
	}
}