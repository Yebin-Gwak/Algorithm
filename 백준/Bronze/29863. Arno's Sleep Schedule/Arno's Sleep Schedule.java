import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N < 4)
			N += 24;
		int M = Integer.parseInt(br.readLine()) + 24;
		System.out.println(M - N);
	}

}