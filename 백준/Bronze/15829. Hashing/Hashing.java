import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int r = 31, m = 1234567891, n = Integer.parseInt(br.readLine());
        BigInteger tmp = new BigInteger("0");
        String input = br.readLine();
        for(int i=0;i<n;i++) {
            int c = input.charAt(i) - 'a' + 1;
            tmp = tmp.add(new BigInteger(Long.toString(Math.round(c*Math.pow(r,i)))));
        }

        System.out.println(tmp.mod(new BigInteger(Integer.toString(m))));
    }
}
