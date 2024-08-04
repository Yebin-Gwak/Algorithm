import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String data = sc.next();
		int count = 0;
		for(int i = 0; i < n; i++) {
			count = (data.charAt(i) == 'o') ? count + 1 : 0;
			if(count == 3) {
				System.out.println("Yes");
				return;
			}
		}
		System.out.println("No");
	}
}