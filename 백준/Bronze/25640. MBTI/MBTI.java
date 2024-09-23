import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int n = sc.nextInt();
		int count = 0;
		for(int i = 0; i < n; i++) {
			if(sc.next().equals(s))
				count++;
		}

		System.out.println(count);

	}
}