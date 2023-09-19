import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m, answer=1, len=0, cnt=0, gap;
        int[] line;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        line = new int[n];
        for(int i=0;i<n;i++) {
            line[i] = Integer.parseInt(br.readLine());
            len = Math.max(len, line[i]);
        }
        len = len/2;
        gap = len/2;
        while(gap > 0) {
            cnt = checkCnt(line, len);

            if(cnt>=m)   {
                answer = len;
                len += gap;
            } else {
                len -= gap;
            }
            gap /= 2;
        }

        while(true) {
            cnt = checkCnt(line, answer);
            if(cnt>=m)  answer++;
            else        break;
        }

        System.out.println(answer-1);
    }

    public static int checkCnt(int[] line, int len) {
        if(len==0) return line.length;
        
        int tmp=0;
        for(int i=0;i<line.length;i++) {
            tmp+=line[i]/len;
        }
        return tmp;
    }
}
