import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int D = 0;
		int P = 0;
		for(int i = 0; i < N; i++) {
			if(br.readLine().equals("D"))
				D++;
			else
				P++;
			if(Math.abs(D - P) > 1)
				break;
		}
		
		System.out.println(D + ":" + P);
	}
}
