import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), tmp=0, curCnt, min=4_000, max=-4_000, maxCnt = 0;
        List<Integer> sorted = new ArrayList<>(), lst = new ArrayList<>();
        Map<Integer, Integer> cnt = new HashMap<>();
        BigInteger sum = new BigInteger("0");
        for(int i=0;i<n;i++) {
            tmp = Integer.parseInt(br.readLine());
            sorted.add(tmp);
            curCnt = cnt.getOrDefault(tmp, 0);
            cnt.put(tmp, curCnt+1);
            maxCnt = Math.max(maxCnt, curCnt+1);
            min = Math.min(min, tmp);
            max = Math.max(max, tmp);
            sum = sum.add(new BigInteger(Integer.toString(tmp)));
        }

        System.out.println(Math.round(sum.floatValue()/n));

        sorted.sort((a,b)->a-b);
        System.out.println(sorted.get(n/2));
        for(int key : cnt.keySet()) if(cnt.get(key)==maxCnt) lst.add(key);
        lst.sort((a,b)->a-b);
        if(lst.size()>1)    System.out.println(lst.get(1));
        else                System.out.println(lst.get(0));
        System.out.println(max-min);
    }
}
