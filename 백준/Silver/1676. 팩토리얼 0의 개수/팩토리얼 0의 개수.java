import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String f = facto(Integer.parseInt(br.readLine()));
        for(int i=0;i<f.length();i++) if(f.charAt(f.length()-1-i)!='0') {
            System.out.println(i);
            return;
        }
    }

    public static String facto(int n) {
        BigInteger ret = new BigInteger("1");
        for(int i=1;i<=n;i++)   ret = ret.multiply(new BigInteger(Integer.toString(i)));
        return ret.toString();
    }
}
