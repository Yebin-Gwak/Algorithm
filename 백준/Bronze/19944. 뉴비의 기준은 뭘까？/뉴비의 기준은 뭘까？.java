import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		if (b == 1 || b == 2) {
			System.out.println("NEWBIE!");
			return;
		}
		if (b > a) {
			System.out.println("TLE!");
		} else {
			System.out.println("OLDBIE!");
		}

	}
}