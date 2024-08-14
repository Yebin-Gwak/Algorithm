import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		for(int i = 0; i < n - 1; i++) {
			if(s.charAt(i + 1) == 'J')
				System.out.println(s.charAt(i));
		}
	}
}