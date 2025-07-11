import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()) * 3 + Integer.parseInt(st.nextToken()) * 20 + Integer.parseInt(st.nextToken()) * 120;
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()) * 3 + Integer.parseInt(st.nextToken()) * 20 + Integer.parseInt(st.nextToken()) * 120;
		if(N == M)
			System.out.println("Draw");
		else if(N > M)
			System.out.println("Max");
		else
			System.out.println("Mel");
	}

}