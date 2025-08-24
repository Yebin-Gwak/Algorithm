import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine()) - N;
		
		if(M < 1)
			System.out.println("Congratulations, you are within the speed limit!");
		else if(M < 21)
			System.out.println("You are speeding and your fine is $100.");
		else if(M < 31)
			System.out.println("You are speeding and your fine is $270.");
		else
			System.out.println("You are speeding and your fine is $500.");
	}
}