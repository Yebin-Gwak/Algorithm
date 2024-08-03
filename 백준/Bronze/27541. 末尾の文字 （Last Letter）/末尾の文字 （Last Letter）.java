import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String data = sc.next();
		if(data.charAt(n - 1) == 'G')
			System.out.println(data.substring(0, n - 1));
		else
			System.out.println(data + "G");
	}
}