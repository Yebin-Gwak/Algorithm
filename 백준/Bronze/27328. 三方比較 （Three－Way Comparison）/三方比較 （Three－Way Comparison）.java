import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int answer = -1;
		if(a == b)
			answer = 0;
		if(a > b)
			answer = 1;
		System.out.println(answer);
	}
}