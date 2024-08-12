import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String a = sc.next();
		String b = sc.next();
		int c = 0;
		for(int i = 0; i < n; i++) if(a.charAt(i) != b.charAt(i)) c++;
		System.out.println(c);
	}
}