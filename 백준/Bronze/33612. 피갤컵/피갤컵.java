import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] year = new int[] {2024, 2025, 2025, 2026, 2026};
		int[] month = new int[] {8, 3, 10, 5, 12};
		int N = Integer.parseInt(br.readLine()) - 1;
		System.out.println(year[N] + " " + month[N]);
	}
}