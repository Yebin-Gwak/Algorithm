import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String data = sc.next();
		char c = data.charAt(0);
		for(int i = 0; i < n; i++) {
			if(c != data.charAt(i)) {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
	}
}