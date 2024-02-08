import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<int[]> gears = new ArrayList<>();
    static List<int[]> chain = new ArrayList<>();
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        setArr();
        setArr();
        setArr();
        setArr();

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int gear = Integer.parseInt(st.nextToken()) - 1;
            int turn = Integer.parseInt(st.nextToken());
            link(gear, turn);
            turn();
        }
        calc();
        System.out.println(ans);
    }

    private static void setArr() throws IOException {
        int[] temp = new int[8];
        String data = br.readLine();
        for (int i = 0; i < 8; i++)
            temp[i] = data.charAt(i) - '0';
        gears.add(temp);
    }

    private static void link(int startGear, int startTurn) {
        List<int[]> tempList = new ArrayList<>();
        tempList.add(new int[]{startGear, startTurn});

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{startGear, startTurn});
        boolean[] visited = new boolean[4];

        while (!deque.isEmpty()) {
            int[] temp = deque.pollFirst();
            int gear = temp[0];
            int turn = temp[1];
            visited[gear] = true;

            if (0 <= gear - 1 && gears.get(gear)[6] != gears.get(gear - 1)[2] && !visited[gear - 1]) {
                deque.add(new int[]{gear - 1, turn * (-1)});
                tempList.add(new int[]{gear - 1, turn * (-1)});
            }
            if (gear + 1 < 4 && gears.get(gear)[2] != gears.get(gear + 1)[6] && !visited[gear + 1]) {
                deque.add(new int[]{gear + 1, turn * (-1)});
                tempList.add(new int[]{gear + 1, turn * (-1)});
            }
        }
        chain = tempList;
    }

    private static void turn() {
        for (int i = 0; i < chain.size(); i++) {
            if (chain.get(i)[1] == 1)
                turnRight(chain.get(i)[0]);
            else
                turnLeft(chain.get(i)[0]);
        }
    }

    private static void turnRight(int index) {
        int[] replace = new int[8];
        int[] original = gears.get(index);

        replace[0] = original[7];
        for (int i = 1; i < 8; i++)
            replace[i] = original[i - 1];
        gears.set(index, replace);
    }

    private static void turnLeft(int index) {
        int[] replace = new int[8];
        int[] original = gears.get(index);

        replace[7] = original[0];
        for (int i = 0; i < 7; i++)
            replace[i] = original[i + 1];
        gears.set(index, replace);
    }

    private static void calc() {
        int value = 1;

        for (int i = 0; i < 4; i++) {
            if (gears.get(i)[0] == 1)
                ans += value;
            value *= 2;
        }
    }


}
