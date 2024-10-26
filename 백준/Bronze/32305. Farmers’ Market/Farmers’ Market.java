import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt() * sc.nextInt();
		int b = sc.nextInt();
		int sum = (a / 12) * b;
		sum += (a % 12 == 0) ? 0 : b;
		System.out.println(sum);
	}
}