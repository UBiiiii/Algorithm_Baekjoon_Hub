import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> s = new Stack<>();
        int n = Integer.parseInt(br.readLine()), tmp=0;
        long answer = 0;
        for(int i=0;i<n;i++) {
            tmp = Integer.parseInt(br.readLine());
            if(tmp==0) {
                if(!s.isEmpty())  s.pop();
            }
            else        s.push(tmp);
        }
        while(!s.isEmpty()) {
            answer+=s.pop();
        }
        System.out.println(answer);
    }
}
