import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if(a + b + c >= 100)
			System.out.println("OK");
		else {
			int m = Math.min(a, Math.min(b, c));
			if(m == a)
				System.out.println("Soongsil");
			if(m == b)
				System.out.println("Korea");
			if(m == c)
				System.out.println("Hanyang");
		}
	}
}