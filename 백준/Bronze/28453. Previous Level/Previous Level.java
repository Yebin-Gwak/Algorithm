import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			if(a == 300)
				System.out.print(1 + " ");
			else if(a >= 275)
				System.out.print(2 + " ");
			else if(a >= 250)
				System.out.print(3 + " ");
			else
				System.out.print(4 + " ");
		}
	}
}