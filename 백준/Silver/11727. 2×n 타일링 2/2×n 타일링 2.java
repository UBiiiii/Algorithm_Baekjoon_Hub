import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] arr = new int[n+1];
    if(n==1)  System.out.println(1);
    else if(n==2) System.out.println(3);
    else {
      arr[1] = 1;
      arr[2] = 3;
      for(int i=3;i<=n;i++) arr[i] = (arr[i-1] + 2*arr[i-2])%10_007;
      System.out.println(arr[n]);
    }
    sc.close();
  }
}