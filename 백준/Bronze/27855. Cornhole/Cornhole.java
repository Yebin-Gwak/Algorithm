import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()) * 3 + Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken()) * 3 + Integer.parseInt(st.nextToken());
		if(a == b)
			System.out.println("NO SCORE");
		else {
			System.out.print( a > b ? 1 : 2);
			System.out.println(" " + Math.abs(a - b));
		}
		
		
	}
}