import java.io.*;
import java.util.*;

public class Main {

    static int[][] parents;
    static boolean[][] guards;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] dp = new int[L + 1];
        Arrays.fill(dp, -1);
        dp[L] = A;

        parents = new int[N + 1][L + 1];
        guards  = new boolean[N + 1][L + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int[] ndp = new int[L + 1];
            Arrays.fill(ndp, -1);

            for (int j = 1; j <= L; j++) {
                int now = dp[j];
                if (now == -1)
                	continue;

                if (x == -1) {
                    int idx = j - y;
                    if (idx > 0) {
                        if (now >= ndp[idx]) {
                            ndp[idx] = now;
                            parents[i + 1][idx] = j;
                            guards[i + 1][idx] = false;
                        }
                    }
                } else if (y == -1) {
                    int aura = Math.max(0, now - x);
                    if (aura >= ndp[j]) {
                        ndp[j] = aura;
                        parents[i + 1][j] = j;
                        guards[i + 1][j] = true;
                    }
                } else {
                    int idx = j - y;
                    if (idx > 0) {
                        if (now >= ndp[idx]) {
                            ndp[idx] = now;
                            parents[i + 1][idx] = j;
                            guards[i + 1][idx] = false;
                        }
                    }
                    if (now >= x) {
                        int aura = now - x;
                        if (aura >= ndp[j]) {
                            ndp[j] = aura;
                            parents[i + 1][j] = j;
                            guards[i + 1][j] = true;
                        }
                    }
                }
            }

            dp = ndp;
        }

        for (int i = 1; i <= L; i++) {
            if (dp[i] != -1) {
                recur(N, i);
                System.out.println("YES");
                System.out.println(sb.reverse().toString());
                return;
            }
        }
        System.out.println("NO");
    }

    private static void recur(int d, int idx) {
        if (d == 0)
        	return;
        sb.append(guards[d][idx] ? 'A' : 'L');
        recur(d - 1, parents[d][idx]);
    }
}
