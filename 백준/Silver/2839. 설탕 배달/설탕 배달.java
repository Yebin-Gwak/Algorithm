import java.util.*;

public class Main {
	public static void main(String[] args){
		int N = new Scanner(System.in).nextInt();

		int ans = 0;
		while(N > 2) {
			if(N % 5 == 0) {
				N -= 5;
				ans++;
			}
			else if(N >= 3){
				N -= 3;
				ans++;
			}
			if(N == 0) {
				System.out.println(ans);
				return;
			}
		}
		System.out.println(-1);
	}
}