import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		if(s.contains("bigdata") ||s.contains("public") ||s.contains("society"))
			System.out.println("public bigdata");
		else
			System.out.println("digital humanities");
	}
}