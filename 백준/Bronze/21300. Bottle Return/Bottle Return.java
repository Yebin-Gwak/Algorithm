import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = 0;
		for(int i = 0; i < 6; i++)
			s += sc.nextInt();
		System.out.println(s * 5);
	}
}