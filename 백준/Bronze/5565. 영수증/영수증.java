import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int cost = sc.nextInt();
		for(int i = 0; i < 9; i++) {
			cost -= sc.nextInt();
		}
		System.out.println(cost);
	}
}