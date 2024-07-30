import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt() + sc.nextInt();
		if(n > 99)
			System.out.println(3);
		else if(n > 9)
			System.out.println(2);
		else
			System.out.println(1);
	}
}