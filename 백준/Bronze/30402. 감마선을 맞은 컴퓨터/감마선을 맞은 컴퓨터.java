import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		w: for(int i = 0; i < 15; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 15; j++) {
				char c = st.nextToken().charAt(0);
				if(c != 'w' && c != 'b' && c != 'g')
					continue;
				if(c == 'w')
					System.out.println("chunbae");
				else if(c == 'b')
					System.out.println("nabi");
				else if(c == 'g')
					System.out.println("yeongcheol");
				break w;
			}
		}
	}
}