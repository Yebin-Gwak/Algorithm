import java.util.*;
import java.io.*;

public class Main {
	static class Human implements Comparable<Human>{
		int arrivedTime;
		int index;

		public Human(int arrivedTime, int index) {
			this.arrivedTime = arrivedTime;
			this.index = index;
		}

		@Override
		public int compareTo(Human o) {
			return this.arrivedTime - o.arrivedTime;
		}

		@Override
		public String toString() {
			return "Human [arrivedTime=" + arrivedTime + ", index=" + index + "]";
		}


		
	}

	
	static int max, distance, N;
	static int size;
	static int time = 0;
	
	static PriorityQueue<Human> left = new PriorityQueue<>();
	static PriorityQueue<Human> right = new PriorityQueue<>();
	static boolean currentPlace = true; // 현재 위치 판별, 왼: true, 오: false
	static Deque<Human> pickups = new ArrayDeque<>();
	static int[] ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		max = Integer.parseInt(st.nextToken());
		distance = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		ans = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int arrivedTime = Integer.parseInt(st.nextToken());
			String arrivedPlace = st.nextToken();

			if(arrivedPlace.equals("left"))
				left.add(new Human(arrivedTime, i));
			else
				right.add(new Human(arrivedTime, i));
		}
		
		while(!(left.isEmpty() && right.isEmpty())) {
			moveNext(); // 여기서 계속 기다릴지, 반대쪽으로 갈지
			pickup(); // 태워서
			move(); // 반대쪽으로 이동
		}
		
		for(int x : ans)
			sb.append(x + "\n");
		System.out.print(sb.toString());
	}

	private static void moveNext() {
		
		if(currentPlace) {
			// 이 정박장에 더는 올 사람이 없다면, 반대 정박장으로 보냄
			if(left.isEmpty()) {
				currentPlace = false;
				time = Math.max(time, right.peek().arrivedTime) + distance;
				return;
			}
			
			// 현재 정류장에서 기다리고 있는 사람이 있다면
			if(left.peek().arrivedTime <= time)
				return;
			
			// 없다면, 현재 정류장의 다음 사람을 기다릴지, 반대 정박장의 다음사람 기다릴지 정함
			else {
				// 반대 정류장에 더는 올 사람이 없다면, 여기서 다음사람 기다리면 됨
				if(right.isEmpty()) {
					time = left.peek().arrivedTime;
					return;
				}
				
				int leftPeek = left.peek().arrivedTime;
				int rightPeek = right.peek().arrivedTime;
				// 현재위치는 왼쪽이니, 왼쪽사람이 더 빨리오거나 동시에 온다면, 여기서 대기
				if(leftPeek <= rightPeek) {
					time = leftPeek;
				}
				// 오른쪽 사람이 더 빨리 온다면, 해당 사람이 도착한 시간 + 그때 출발해서 오른쪽으로 이동하는 시간으로  도착 시간 설정
				else {
					currentPlace = false;
					time = Math.max(time, rightPeek) + distance;
				}
			}
			
		}
		else {
			// 이 정박장에 더는 올 사람이 없다면, 반대 정박장으로 보냄
			if(right.isEmpty()) {
				currentPlace = true;
				time = Math.max(time, left.peek().arrivedTime) + distance;
				return;
			}
			
			
			// 현재 정류장에서 기다리고 있는 사람이 있다면
			if(right.peek().arrivedTime <= time)
				return;
			// 없다면, 현재 정류장의 다음 사람을 기다릴지, 반대 정박장의 다음사람 기다릴지 정함
			else {
				// 반대 정류장에 더는 올 사람이 없다면, 여기서 계속 기다리면 됨
				if(left.isEmpty()) {
					time = right.peek().arrivedTime;					
					return;
				}
				
				int leftPeek = left.peek().arrivedTime;
				int rightPeek = right.peek().arrivedTime;
				// 현재위치는 오른쪽이니, 오른쪽사람이 더 빨리오거나 동시에 온다면, 여기서 대기
				if(rightPeek <= leftPeek) {
					time = rightPeek;
				}
				// 왼쪽 사람이 더 빨리 온다면, 해당 사람이 도착한 시간 + 그때 출발해서 오른쪽으로 이동하는 시간으로  도착 시간 설정
				else {
					currentPlace = true;
					time = Math.max(time, leftPeek) + distance;
				}
			}
		}
		
		
	}
	
	private static void pickup() {
		if(currentPlace) {
			while(!left.isEmpty()) {
				if(left.peek().arrivedTime <= time)
					pickups.add(left.poll());
				else
					break;
				if(pickups.size() == max)
					break;
			}
		}
		else {
			while(!right.isEmpty()) {
				if(right.peek().arrivedTime <= time)
					pickups.add(right.poll());
				else
					break;
				if(pickups.size() == max)
					break;
			}
		}
		
	}
	private static void move() {
		currentPlace = (currentPlace) ? false : true;
		time += distance;
		while(!pickups.isEmpty())
			ans[pickups.poll().index] = time;
		
	}

}