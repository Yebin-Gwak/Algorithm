import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N > 100000 || N % 2024 != 0)
			System.out.println("No");
		else
			System.out.println("Yes");
	}
}