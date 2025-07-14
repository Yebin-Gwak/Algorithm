import java.io.*;
import java.math.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String s = br.readLine();
			if(s.equals("0"))
				break;
			BigInteger n = new BigInteger(s);
			if(n.mod(BigInteger.valueOf(42)) == BigInteger.ZERO)
				sb.append("PREMIADO");
			else
				sb.append("TENTE NOVAMENTE");
			
			sb.append("\n");
		}
		
		System.out.print(sb);
		
	}

}