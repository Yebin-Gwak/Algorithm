import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
//		int[][] B = new int[N + 1][N + 1];
//		배열 크기를 K까지만 주면, 필요한 부분만큼만 배열 생성(끝이 잘린 삼각형)
		int[][] B = new int[N + 1][K + 1];
		
		for(int i = 0; i <= N; i++) {
			for(int j = 0, end = Math.min(i, K); j <= end; ++j) {
				if(j == 0 || j == i) B[i][j] = 1;
				else
					// nCk      (n-1)C(k-1)      (n-1)C(k)
					B[i][j] = (B[i - 1][j - 1] + B[i - 1][j]) % 10007;
			}
		}
		
		System.out.println(B[N][K]);

	}

}