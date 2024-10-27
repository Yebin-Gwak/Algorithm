import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {			
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = b * 2;
			System.out.println((c - a) + " " + (b - (c - a)));
		}
	}
}