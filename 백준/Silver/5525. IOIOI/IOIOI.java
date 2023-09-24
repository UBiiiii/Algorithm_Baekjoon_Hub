import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n, m, start = 0, answer=0;
    StringBuffer sb = new StringBuffer("I");
    n = Integer.parseInt(br.readLine());
    for(int i=0;i<n;i++)  sb.append("OI");
    m = Integer.parseInt(br.readLine());
    String input = br.readLine();
    String p = sb.toString();
    while(input.indexOf(p, start)!=-1) {
      answer++;
      start = input.indexOf(p, start)+1;
    }

    System.out.println(answer);
  }

}

