import java.util.*;
import java.io.*;

public class Main {
	static class Group implements Comparable<Group>{
		int size, rainbowCount, color;
		int px, py;
		List<Block> blocks;
		
		public Group(int size, int rainbowCount, int px, int py, int color, ArrayList<Block> blocks) {
			this.size = size;
			this.rainbowCount = rainbowCount;
			this.px = px;
			this.py = py;
			this.color = color;
			this.blocks = blocks;
		}

		@Override
		public int compareTo(Group o) {
			if(o.size == this.size) {
				if(o.rainbowCount == this.rainbowCount) {
					if(o.px == this.px) {
						return o.py - this.py;
					}
					return o.px - this.px;
				}
				return o.rainbowCount - this.rainbowCount;
			}
			return o.size - this.size;
		}
		
	}
	
	static class Block implements Comparable<Block>{
		int x, y;

		public Block(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Block o) {
			if(this.x == o.x)
				return this.y - o.y;
			return this.x - o.x;
		}
		
	}
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static PriorityQueue<Group> pqOfGroups = new PriorityQueue<>();
	static PriorityQueue<Block> pqOfBlocks = new PriorityQueue<>();
	static List<Block> rainbowBlocks = new ArrayList<>();
	static List<Block> blocks = new ArrayList<>();
	static Deque<Block> deque = new ArrayDeque<>();
	
	static int score = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		while(true) {
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] > 0 && !visited[i][j]) {
						Group group = findGroup(i, j);
						if(group != null)
							pqOfGroups.add(group);
					}
						
				}
			}
			
			if(pqOfGroups.size() == 0)
				break;
			
			Group g = pqOfGroups.poll();
			boom(g);
			fall();
			turn();
			fall();
			
		}
		System.out.println(score);
		
		
	}

    private static void turn() {
        int[][] rotatedMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rotatedMap[N - j - 1][i] = map[i][j];
            }
        }

        map = rotatedMap;
    }

	private static void fall() {
		for(int i = N - 2; i >= 0; i--) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] < 0)
					continue;
				if(map[i + 1][j] >= -1 && map[i + 1][j] != -2)
					continue;
				int color = map[i][j];
				int x = i;
				int y = j;
				int h = 0;
				boolean hitBlock = false;
				boolean hitGround = false;
				while (true) {
					h++;
					if (map[x + h][y] >= -1)
						hitBlock = true;
					if (x + h == N - 1)
						hitGround = true;
					if (hitBlock) {
						map[x + h - 1][y] = color;
						map[x][y] = -2;
						break;
					}
					if (hitGround) {
						map[x + h][y] = color;
						map[x][y] = -2;
						break;
					}

				}
				
			}
		}
		
	}

	private static void boom(Group group) {
		score += group.size * group.size;
		for(Block b : group.blocks) {
			map[b.x][b.y]= -2; 
		}
		pqOfGroups.clear();
		
	}

	private static Group findGroup(int startX, int startY) {
		int color = map[startX][startY];
		int rainbowCount = 0;
		
		blocks.clear();
		pqOfBlocks.clear();
		deque.clear();
		deque.add(new Block(startX, startY));
		pqOfBlocks.add(new Block(startX, startY));
		boolean[][] tempVisited = new boolean[N][N];
		visited[startX][startY] = true;
		tempVisited[startX][startY] = true;
		
		while(!deque.isEmpty()) {
			Block now = deque.poll();
			blocks.add(now);
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < N && (map[nx][ny] == 0 || map[nx][ny] == color) && !tempVisited[nx][ny]) {
					tempVisited[nx][ny] = true;
					Block b = new Block(nx, ny);
					deque.add(b);
					if(map[nx][ny] == 0)
						rainbowCount++;
					else {
						visited[nx][ny] = true;
						pqOfBlocks.add(b);
					}
					
				}
			}
		}
		if(blocks.size() == 1)
			return null;
		Block pointBlock = pqOfBlocks.poll();
		return new Group(blocks.size(), rainbowCount, pointBlock.x, pointBlock.y, color, new ArrayList<Block>(blocks));
		
	}
}