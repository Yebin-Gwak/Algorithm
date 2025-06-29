import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = " @@@   @@@  \n"
				+ "@   @ @   @ \n"
				+ "@    @    @ \n"
				+ "@         @ \n"
				+ " @       @  \n"
				+ "  @     @   \n"
				+ "   @   @    \n"
				+ "    @ @     \n"
				+ "     @      \n";
		
		sb.append(s.repeat(Integer.parseInt(br.readLine())));
		System.out.print(sb.toString());
		
	}

}