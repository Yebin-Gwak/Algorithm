import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = (int) Math.pow(2, N - 1);
		System.out.println(sc.nextInt() / cnt);
	}
}
