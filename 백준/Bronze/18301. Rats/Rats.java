import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()) + 1;
		int B = Integer.parseInt(st.nextToken()) + 1;
		int C = Integer.parseInt(st.nextToken()) + 1;
		System.out.println(A * B / C - 1);
	}

}