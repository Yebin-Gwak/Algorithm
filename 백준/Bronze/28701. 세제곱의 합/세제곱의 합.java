import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int v = N * (N + 1) / 2;
		System.out.println(v);
		System.out.println(v * v);
		System.out.println(v * v);
		
	}
}