import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		if(n.equals("n") || n.equals("N")) {
			System.out.println("Naver D2");
		}else {
			System.out.println("Naver Whale");
		}
	}
}