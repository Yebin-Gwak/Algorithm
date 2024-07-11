import java.io.*;
import java.util.Arrays;

public class Main {
    static int[][] map = new int[9][9];
    static boolean find = false;
    static boolean[] visited = new boolean[10];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        w: for (int tc = 0; tc < t; tc++) {
            find = false;
            for (int i = 0; i < 9; i++) {
                String data = br.readLine();
                for (int j = 0; j < 9; j++)
                    map[i][j] = data.charAt(j) - '0';
            }

            dfs(0, 0);

            if (find) {
                // 행 검사
                for (int i = 0; i < 9; i++) {
                    Arrays.fill(visited, false);
                    for (int j = 0; j < 9; j++) {
                        if (visited[map[i][j]]) {
                            sb.append("Could not complete this grid.").append("\n");
                            continue w;
                        }
                        visited[map[i][j]] = true;
                    }
                }

                // 열 검사
                for (int i = 0; i < 9; i++) {
                    Arrays.fill(visited, false);
                    for (int j = 0; j < 9; j++) {
                        if (visited[map[j][i]]) {
                            sb.append("Could not complete this grid.").append("\n");
                            continue w;
                        }
                        visited[map[j][i]] = true;
                    }
                }

                // 3x3 박스 검사
                for (int k = 0; k < 9; k += 3) {
                    for (int l = 0; l < 9; l += 3) {
                        Arrays.fill(visited, false);
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                if (visited[map[k + i][l + j]]) {
                                    sb.append("Could not complete this grid.").append("\n");
                                    continue w;
                                }
                                visited[map[k + i][l + j]] = true;
                            }
                        }
                    }
                }

                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++)
                        sb.append(map[i][j]);
                    sb.append("\n");
                }
            } else {
                sb.append("Could not complete this grid.").append("\n");
            }

            if (tc < t - 1) {
                sb.append("\n");
            }
        }

        System.out.print(sb.toString());
    }

    private static void dfs(int x, int y) {
        if (find)
            return;
        if (x == 9) {
            find = true;
            return;
        }
        if (map[x][y] != 0) {
            if (y == 8)
                dfs(x + 1, 0);
            else
                dfs(x, y + 1);
        } else {
            for (int i = 1; i < 10; i++) {
                if (colCheck(x, i) && rowCheck(y, i) && squareCheck(x, y, i)) {
                    map[x][y] = i;
                    if (y == 8) {
                        dfs(x + 1, 0);
                    } else {
                        dfs(x, y + 1);
                    }
                    if (find)
                        return;
                    map[x][y] = 0;
                }
            }
        }
    }

    private static boolean colCheck(int x, int num) {
        for (int i = 0; i < 9; i++) {
            if (map[x][i] == num)
                return false;
        }
        return true;
    }

    private static boolean rowCheck(int y, int num) {
        for (int i = 0; i < 9; i++) {
            if (map[i][y] == num)
                return false;
        }
        return true;
    }

    private static boolean squareCheck(int x, int y, int num) {
        x = 3 * (x / 3);
        y = 3 * (y / 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[x + i][y + j] == num)
                    return false;
            }
        }
        return true;
    }
}