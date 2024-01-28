import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		int R = 1;
		int C = str.length();
		
		for(int i = 1; i < str.length(); i++) {
			if(i >= C)
				break;
			else if(str.length() % i == 0) {
				R = i;
				C = str.length() / i;
			}
		}
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++)
				System.out.print(str.charAt((j * R) + i));
		}

	}

}