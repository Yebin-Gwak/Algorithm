import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		a += Integer.parseInt(st.nextToken());
		b += Integer.parseInt(st.nextToken());
		
		if(a == b)
			System.out.println("Either");
		else
			System.out.println((a < b) ? "Hanyang Univ." : "Yongdap");
	}
}
