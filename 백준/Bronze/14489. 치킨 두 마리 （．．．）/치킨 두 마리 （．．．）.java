import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(br.readLine()) * 2;
		if(a >= b)
			System.out.println(a - b);
		else
			System.out.println(a);
	}
}