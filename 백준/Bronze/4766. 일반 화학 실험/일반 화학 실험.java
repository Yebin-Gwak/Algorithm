import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		double d = Double.parseDouble(br.readLine());
		while(true) {
			double n = Double.parseDouble(br.readLine());
			if(n == 999) return;
			System.out.printf("%.2f", n - d);
			System.out.println();
			d = n;
		}
	}
}