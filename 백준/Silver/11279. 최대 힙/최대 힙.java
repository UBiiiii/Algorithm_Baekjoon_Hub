import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int lastIdx;
	static int[] heap;
	static StringBuilder sb = new StringBuilder(); 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		heap = new int[n+1];
		lastIdx = 0;
		
		for(int i=0;i<n;i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				sb.append(heap[lastIdx>0 ? 1 : 0] + "\n");
				if(lastIdx!=0) {
					poll(heap[lastIdx--], 1);
				}
			} else {
				offer(input, ++lastIdx);
			}
		}
		
		System.out.println(sb.toString());
	}
	
	private static void offer(int n, int idx) {
		int pIdx = idx/2;
		if(pIdx == 0 || heap[pIdx] >= n) heap[idx]=n;
		else {
			heap[idx] = heap[pIdx];
			offer(n, pIdx);
		}
	}
	
	private static void poll(int n, int idx) {
		int lidx = idx*2;
		int ridx = idx*2+1;
		
		int left = lidx <= lastIdx ? heap[lidx] : -1;
		int right = ridx <= lastIdx ? heap[ridx] : -1;
		
		if(left > n || right > n) {
			if(left > right) {
				heap[idx] = left;
				poll(n, lidx);
			} else {
				heap[idx] = right;
				poll(n, ridx);
			}
		} else {
			heap[idx] = n;
		}
		
	}

}
