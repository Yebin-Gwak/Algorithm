import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char c = br.readLine().charAt(0);
		if(c == 'F')
			System.out.println("Foundation");
		else if(c == 'C')
			System.out.println("Claves");
		else if(c == 'V')
			System.out.println("Veritas");
		else if(c == 'E')
			System.out.println("Exploration");
	}
}