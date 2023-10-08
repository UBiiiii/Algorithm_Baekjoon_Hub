import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int s,e;
		
		String[] input = br.readLine().split(" ");
		int[] arr = new int[Integer.parseInt(input[0])+1];
		int caseNum = Integer.parseInt(input[1]);
		String[] numInput = br.readLine().split(" ");
		
		for(int i=0;i<numInput.length;i++) {
			arr[i+1] = arr[i]+Integer.parseInt(numInput[i]);
		}
		
		for(int i=0;i<caseNum;i++) {
			String[] caseInput = br.readLine().split(" ");
			s = Integer.parseInt(caseInput[0]);
			e = Integer.parseInt(caseInput[1]);
			System.out.println(arr[e] - arr[s-1]);
		}
	}
}
