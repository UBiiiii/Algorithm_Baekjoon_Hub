import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder isb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Character> s = new Stack<>();
        String str;

        for(int i=0;i<n;i++) {
            s.clear();
            str = br.readLine();
            isb.append(str).append("\n");
            for(int j=0;j<str.length();j++) {
                if(str.charAt(j)=='(') s.push('(');
                else {
                    if(!s.isEmpty()&&s.peek()=='(')   s.pop();
                    else                s.push(')');
                }
            }
            sb.append(s.isEmpty() ? "YES\n" : "NO\n");
        }
        System.out.println(sb.toString());
    }
}
