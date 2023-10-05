import java.util.Scanner;

public class Main {
	
	static int n, k, cnt;
	static int[] money;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		cnt = 0;
		money = new int[n];
		
		for(int i=0;i<n;i++) {
			money[n-1-i] = sc.nextInt();
		}
		
		int i=0;
		while(k>0) {
			cnt += k/money[i];
			k = k%money[i++];
		}
		
		System.out.println(cnt);
		sc.close();
	}

}
