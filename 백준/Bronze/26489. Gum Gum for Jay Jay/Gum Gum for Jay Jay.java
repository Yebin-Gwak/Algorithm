import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		String s;
		while(true) {
			s = br.readLine();
			if(s == null)
				break;
			n++;
		}
		System.out.println(n);
	}

}