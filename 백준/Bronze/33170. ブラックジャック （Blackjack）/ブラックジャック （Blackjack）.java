import java.io.*;
import java.math.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()) + Integer.parseInt(br.readLine()) + Integer.parseInt(br.readLine());
		System.out.println((N <= 21) ? 1 : 0);
		
	}

}