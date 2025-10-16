import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt("1".repeat(Integer.parseInt(st.nextToken())));
		int b = Integer.parseInt("1".repeat(Integer.parseInt(st.nextToken())));
		System.out.println(a + b);
	}
}