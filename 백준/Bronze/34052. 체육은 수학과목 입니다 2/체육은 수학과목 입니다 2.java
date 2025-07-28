import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int v = 0;
		for(int i = 0; i < 4; i++)
			v += Integer.parseInt(br.readLine());
		System.out.println(v < 1501 ? "Yes" : "No");
	}
}