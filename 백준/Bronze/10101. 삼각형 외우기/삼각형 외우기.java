import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		if (a + b + c != 180) {
			System.out.println("Error");
			return;
		}
		if (a == 60 && b == 60 && c == 60) {
			System.out.println("Equilateral");
			return;
		}
		if (a != b && b != c && a != c) {
			System.out.println("Scalene");
			return;
		}
		System.out.println("Isosceles");
		return;
	}
}