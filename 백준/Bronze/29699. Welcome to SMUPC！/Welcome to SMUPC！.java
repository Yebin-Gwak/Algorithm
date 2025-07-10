import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "WelcomeToSMUPC";
		int n = Integer.parseInt(br.readLine());
		n = (n % 14 == 0) ? 13 : n % 14 - 1;
		System.out.print(s.charAt(n));
	}

}