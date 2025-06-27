import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int v = br.readLine().length();
			sb.append((v >= 6 && v <= 9) ? "yes" : "no").append("\n");
		}
		
		System.out.print(sb.toString());
		
	}

}