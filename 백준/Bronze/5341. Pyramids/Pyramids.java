import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				break;
			sb.append(n * (n + 1) / 2).append("\n");
		}
		System.out.print(sb.toString());
	}

}