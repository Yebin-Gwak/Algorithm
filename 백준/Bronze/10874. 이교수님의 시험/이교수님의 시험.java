import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 1; i <= T; i++) {
			String s = br.readLine();
			if(s.equals("1 2 3 4 5 1 2 3 4 5")) {
				System.out.println(i);
			}
		}
	}
}