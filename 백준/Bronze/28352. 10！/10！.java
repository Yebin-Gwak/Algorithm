import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 6;
		for(int i = 11; i <= n; i++)
			ans *= i;
		System.out.println(ans);
	}
}