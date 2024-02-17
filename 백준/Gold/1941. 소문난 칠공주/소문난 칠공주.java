import java.util.*;
import java.io.*;

public class Main {
	static char[][] map = new char[5][5];

	static List<int[]> address = new ArrayList<>();
	static int[] nums = new int[25];
	static int[] result = new int[7];
	static boolean[] visited = new boolean[25];

	static Deque<List<Integer>> results = new ArrayDeque<>();

	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			String data = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = data.charAt(j);
				address.add(new int[] { i, j });
			}
		}

		for (int i = 0; i < 25; i++)
			nums[i] = i;

		comb(0, 0, 0, 0);

		while (!results.isEmpty())
			bfs();
		System.out.println(ans);

	}

	private static void comb(int cnt, int start, int cntS, int cntN) {
		if (cntN > 3)
			return;

		if (cnt == 7) {
			int[] tempResult = result.clone();
			List<Integer> tempList = new ArrayList<>();

			for (int i = 0; i < 7; i++)
				tempList.add(tempResult[i]);
			results.add(tempList);
			return;
		}

		for (int i = start; i < 25; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			result[cnt] = nums[i];
			int[] temp = address.get(i);
			int x = temp[0];
			int y = temp[1];

			if (map[x][y] == 'S')
				comb(cnt + 1, i + 1, cntS + 1, cntN);
			else
				comb(cnt + 1, i + 1, cntS, cntN + 1);

			visited[i] = false;

		}

	}

	private static void bfs() {
		List<Integer> temp = results.pollFirst();
		boolean[] visited = new boolean[25];
		
		Deque<Integer> deque = new ArrayDeque<>();
		deque.add(temp.get(0));
		visited[temp.get(0)] = true;
		
		int count = 0;
		while(!deque.isEmpty()) {
			count++;
			int num = deque.pollFirst();
			
			if(1 <= num && num < 4) {
				if(temp.contains(num - 1) && !visited[num - 1]) {
					visited[num - 1] = true;
					deque.add(num - 1);
				}
				if(temp.contains(num + 1) && !visited[num + 1]) {
					visited[num + 1] = true;
					deque.add(num + 1);
				}
				if(temp.contains(num + 5) && !visited[num + 5]) {
					visited[num + 5] = true;
					deque.add(num + 5);
				}
			}
			

			
			else if(21 <= num && num < 24) {
				if(temp.contains(num - 1) && !visited[num - 1]) {
					visited[num - 1] = true;
					deque.add(num - 1);
				}
				if(temp.contains(num + 1) && !visited[num + 1]) {
					visited[num + 1] = true;
					deque.add(num + 1);
				}
				if(temp.contains(num - 5) && !visited[num - 5]) {
					visited[num - 5] = true;
					deque.add(num - 5);
				}
			}
			
			else if (num == 0 || num == 5 || num == 10 || num == 15 || num == 20) {
				if(num != 0) {
					if(temp.contains(num - 5) && !visited[num - 5]) {
						visited[num - 5] = true;
						deque.add(num - 5);
					}
				}
				if(temp.contains(num + 1) && !visited[num + 1]) {
					visited[num + 1] = true;
					deque.add(num + 1);
				}
				if(num != 20) {
					if(temp.contains(num + 5) && !visited[num + 5]) {
						visited[num + 5] = true;
						deque.add(num + 5);
					}

				}
			}
			
			else if (num == 4 || num == 9 || num == 14 || num == 19 || num == 24) {
				if(num != 4) {
					if(temp.contains(num - 5) && !visited[num - 5]) {
						visited[num - 5] = true;
						deque.add(num - 5);
					}
				}
				if(temp.contains(num - 1) && !visited[num - 1]) {
					visited[num - 1] = true;
					deque.add(num - 1);
				}
				if(num != 24) {
					if(temp.contains(num + 5) && !visited[num + 5]) {
						visited[num + 5] = true;
						deque.add(num + 5);
					}
					
				}
				
			}
			
			else {
				if(temp.contains(num - 5) && !visited[num - 5]) {
					visited[num - 5] = true;
					deque.add(num - 5);
				}
				if(temp.contains(num - 1) && !visited[num - 1]) {
					visited[num - 1] = true;
					deque.add(num - 1);
				}
				if(temp.contains(num + 1) && !visited[num + 1]) {
					visited[num + 1] = true;
					deque.add(num + 1);
				}
				if(temp.contains(num + 5) && !visited[num + 5]) {
					visited[num + 5] = true;
					deque.add(num + 5);
				}
				
			}
			
		}

		if(count == 7)
			ans++;
		
	}

}
