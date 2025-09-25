import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int max = Math.max(a, Math.max(b, c));
		if(a == b || b == c || a == c)
			System.out.println("S");
		else if(a + b + c - max == max)
			System.out.println("S");
		else
			System.out.println("N");
	}
}