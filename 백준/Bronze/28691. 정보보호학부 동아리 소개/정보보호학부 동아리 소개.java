import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		if(n.equals("M")) {
			System.out.println("MatKor");
		}else if(n.equals("W")){
			System.out.println("WiCys");
		}else if(n.equals("C")){
			System.out.println("CyKor");
		}else if(n.equals("A")){
			System.out.println("AlKor");
		}else if(n.equals("$")){
			System.out.println("$clear");
		}
	}
}
