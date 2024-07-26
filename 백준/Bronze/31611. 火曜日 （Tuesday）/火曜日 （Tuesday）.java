import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println((new Scanner(System.in).nextInt() % 7 == 2) ? "1" : 0);
	}
}
