import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();

		int helmet = 0;
		for(int i = 0; i < n; i++) {
			helmet = Math.max(helmet, sc.nextInt());
		}
		int armor = 0;
		for(int i = 0; i < m; i++) {
			armor = Math.max(armor, sc.nextInt());
		}
		System.out.println(helmet + armor);
	}
}