import java.util.*;
import java.io.*;

public class Main {
	
	static class Ninja{
		int idx;
		long leadership;
		ArrayList<Ninja> childs = new ArrayList<>();
		PriorityQueue<Long> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o2, o1));
		long totalMoney = 0;
		
		public Ninja(int idx, long salary, long leadership) {
			this.idx = idx;
			totalMoney += salary;
			this.leadership = leadership;
		}
		
		public void play(){
			for(Ninja child : childs)
				child.play();
			
			pq.add(totalMoney);
			for(Ninja child : childs) {
				totalMoney += child.totalMoney;
				if(child.pq.size() > pq.size()) {
					child.pq.addAll(pq);
					pq = child.pq;
				}else
					pq.addAll(child.pq);
			}
			
			while(totalMoney > M)
				totalMoney -= pq.poll();
			
			ans = Math.max(ans, pq.size() * leadership);
			
		}
		
	}
	
	static long M;
	static Ninja[] ninjas;
	static long ans = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ninjas = new Ninja[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken()) -1;
			int s = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			ninjas[i] = new Ninja(i, s, l);
			if(p != -1)
				ninjas[p].childs.add(ninjas[i]);
		}
		
		ninjas[0].play();
		
		System.out.println(ans);
		
	}
}