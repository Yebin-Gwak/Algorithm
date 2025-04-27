import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String data = br.readLine();
		int count = 0;
		for(int i = 0; i < N; i++) {
			char c = data.charAt(i);
			if(c == 'a' || c == 'i' || c == 'u' || c == 'e' || c == 'o')
				count++;
		}
		System.out.println(count);
	}

}