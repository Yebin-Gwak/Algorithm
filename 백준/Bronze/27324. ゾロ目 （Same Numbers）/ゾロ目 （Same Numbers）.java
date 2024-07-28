import java.util.*;

public class Main {
	public static void main(String[] args) {
		int a = new Scanner(System.in).nextInt();
		System.out.println((a / 10 == a % 10) ? 1 : 0);
	}
}