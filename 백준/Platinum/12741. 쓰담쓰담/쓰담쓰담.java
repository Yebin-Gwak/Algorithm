import java.io.*;
import java.util.*;

public class Main {
	
	static class SegTree{
		int N;
		int[] arr;
		boolean[] tree;
		
		public SegTree(int[] arr) {
			N = arr.length - 2;
			this.arr = arr;
			tree = new boolean[N * 4];
			init(1, 1, N);
		}

		void init(int idx, int start, int end) {
			if(start == end) {
				tree[idx] = arr[start] <= arr[start + 1];
				return;
			}
			
			int mid = (start + end) / 2;
			init(idx * 2, start, mid);
			init(idx * 2 + 1, mid + 1, end);
			tree[idx] = tree[idx * 2] && tree[idx * 2 + 1];
		}
		
		public void update(int left, int right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			if(left != 1)
				update(1, 1, N, left - 1);
			update(1, 1, N, left);
			update(1, 1, N, right - 1);
			update(1, 1, N, right);
		}
		
		private void update(int idx, int start, int end, int target) {
			if(start == end) {
				tree[idx] = arr[target] <= arr[target + 1];
				return;
			}
			
			int mid = (start + end) / 2;
			if(target <= mid)
				update(idx * 2, start, mid, target);
			else
				update(idx * 2 + 1, mid + 1, end, target);
			tree[idx] = tree[idx * 2] && tree[idx * 2 + 1];
		}
		
		public String query(int left, int right) {
			return query(1, 1, N, left, right) ? "CS204" : "HSS090";
		}
		
		private boolean query(int idx, int start, int end, int left, int right) {
			if(start > right || end < left)
				return true;
			if(left <= start && end <= right)
				return tree[idx];
			
			int mid = (start + end) / 2;
			
			return query(idx * 2, start, mid, left, right) &&
					query(idx * 2 + 1, mid + 1, end, left, right);
		}
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 2];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		arr[N + 1] = Integer.MAX_VALUE;
		
		SegTree segTree = new SegTree(arr);
		
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			if(q == 1)
				sb.append(segTree.query(l, r - 1)).append("\n");
			else
				segTree.update(l, r);
		}
		
		System.out.println(sb.toString());
		
	}
}