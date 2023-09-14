import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), sum = 0;
        int[] input = new int[n];
        int k = (int)Math.round(n*15/(double)100);
        if(n==0) {
            System.out.println(0);
            return;
        }

        for(int i=0;i<n;i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(input);

        for(int i=k;i<n-k;i++) {
            sum += input[i];
        }

        System.out.println(Math.round((double)sum/(n-2*k)));
    }
}
