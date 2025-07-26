import java.io.*;
import java.util.*;

public class Main {
	
	static class SegTree{
		int[] tree;
		int n;
		
		SegTree(int[] arr){
			n = arr.length;
			tree = new int[n * 4];
			init(1, 1, n, arr);
		}
		
		void init(int idx, int start, int end, int[] arr) {
			if(start == end) {
				tree[idx] = arr[start - 1];
				return;
			}
			int mid = (start + end) / 2;
			init(idx * 2, start, mid, arr);
			init(idx * 2 + 1, mid + 1, end, arr);
			tree[idx] = tree[idx * 2] * tree[idx * 2 + 1];
		}
		
		void update(int target, int v) {
			if(v == 0) {
				update(1, 1, n, target, 0);
				return;
			}
			if(v > 0)
				update(1, 1, n, target, 1);
			else
				update(1, 1, n, target, -1);
		}
		
		void update(int idx, int start, int end, int target, int v) {
			if(start == end) {
				tree[idx] = v;
				return;
			}
			int mid = (start + end) / 2;
			if(target <= mid)
				update(idx * 2, start, mid, target, v);
			else
				update(idx * 2 + 1, mid + 1, end, target, v);
			tree[idx] = tree[idx * 2] * tree[idx * 2 + 1];
		}
		
		char query(int left, int right) {
			int v = query(1, 1, n, left, right);
			if(v == 0)
				return '0';
			return (v > 0) ? '+' : '-';
		}
		
		int query(int idx, int start, int end, int left, int right) {
			if(start > right || end < left)
				return 1;
			if(left <= start && end <= right)
				return tree[idx];
			int mid = (start + end) / 2;
			return query(idx * 2, start, mid, left, right) *
					query(idx * 2 + 1, mid + 1, end, left, right);
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while(true) {
			String s = br.readLine();
			if(s == null)
				break;
			st = new StringTokenizer(s);
			int N = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int v = Integer.parseInt(st.nextToken());
				if(v == 0)
					continue;
				arr[i] = (v > 0) ? 1 : -1;
			}
			
			SegTree segTree = new SegTree(arr);
			for(int i = 0; i < Q; i++) {
				st = new StringTokenizer(br.readLine());
				String c = st.nextToken();
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(c.equals("C"))
					segTree.update(a, b);
				else
					sb.append(segTree.query(a, b));
			}
			sb.append("\n");
			
		}
		
		System.out.print(sb.toString());
	}
}