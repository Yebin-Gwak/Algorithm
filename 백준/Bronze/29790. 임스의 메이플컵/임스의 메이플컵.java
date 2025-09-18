import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		if(a >= 1000 && (b >= 8000 || c >= 260))
			System.out.println("Very Good");
		else if(a >= 1000)
			System.out.println("Good");
		else
			System.out.println("Bad");
	}
}