import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	
	static int n, answer = -1;
	static int[][] input;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		input = new int[n][2];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
			
		mergeSort(0, n-1);
		
		int[] pre = new int[] {-1, -1};
		answer = 0;
		
		for(int i=0;i<n;i++) {
			int tmp[] = input[i];
			if(tmp[0] >= pre[1]) {
				answer++;
				pre = tmp;
			}
		}
			
		System.out.println(answer);
	}
	
	private static void mergeSort(int s, int e) {
		if(e<=s) return;
		
		int center = (e+s)/2;
		
		mergeSort(s,center);
		mergeSort(center+1,e);
		
		int left = s, right = center+1, cnt = 0;
		int[][] tmp = new int[e-s+1][2];
		while(left<=center && right<=e) {
			if(input[left][1] > input[right][1]) 	tmp[cnt++] = input[right++];
			else if(input[left][1] == input[right][1] && input[left][0] > input[right][0]) tmp[cnt++] = input[right++];
			else																	tmp[cnt++] = input[left++];
		}
		
		while(left<=center ) {
			tmp[cnt++] = input[left++];
		}
		
		while(right<=e) {
			tmp[cnt++] = input[right++];
		}
		
		for(int i=0;i<e-s+1;i++) {
			input[s+i] = tmp[i];
		}
		
	}

}
