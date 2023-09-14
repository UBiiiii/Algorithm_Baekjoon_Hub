import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = 1234567891, n = Integer.parseInt(br.readLine());
        BigInteger tmp = new BigInteger("0"), ri = new BigInteger("1");
        String input = br.readLine();
        for(int i=0;i<n;i++) {
            int c = input.charAt(i) - 'a' + 1;
            tmp = tmp.add(ri.multiply(new BigInteger(Integer.toString(c))));
            ri = ri.multiply(new BigInteger("31"));
        }

        System.out.println(tmp.mod(new BigInteger(Integer.toString(m))));
    }
}
