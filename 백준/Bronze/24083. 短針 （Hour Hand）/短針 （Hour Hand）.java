import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = (sc.nextInt() + sc.nextInt()) % 12;
		System.out.println((a == 0) ? 12 : a);
	}
}