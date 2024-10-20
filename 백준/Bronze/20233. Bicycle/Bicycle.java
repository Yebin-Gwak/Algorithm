import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int e = sc.nextInt();
		int cost1 = a + ((((e > 30) ? e - 30 : 0) * b)) * 21;
		int cost2 = c + ((((e > 45) ? e - 45 : 0) * d)) * 21;
		System.out.println(cost1 + " " + cost2);
	}
}