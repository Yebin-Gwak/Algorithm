import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		if(a == b && b == c)
			System.out.println("*");
		else if(a == b)
			System.out.println("C");
		else if(b == c)
			System.out.println("A");
		else if(a == c)
			System.out.println("B");
	}
}