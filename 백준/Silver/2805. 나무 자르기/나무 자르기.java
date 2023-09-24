import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n, m;
    long answer, gap, tmp;
    long[] tree;
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    tree = Arrays.stream(br.readLine().split(" ")).mapToLong(el->Long.parseLong(el)).sorted().toArray();
    answer = tree[n-1];
    gap = answer/2;
    while(gap>0) {
      tmp = getWood(tree, answer);
      if(tmp >= m)  answer += gap;
      else          answer -= gap;
      gap /= 2;
    }

    while(true) {
      tmp = getWood(tree, answer);
      if(tmp < m && tmp>=0)  answer -= 1;
      else          break;
    }

    while(true) {
      tmp = getWood(tree, answer);
      if(tmp >= m)  answer += 1;
      else          break;
    }

    System.out.println(answer-1);

  }

  private static long getWood(long[] tree, long len) {
    long cnt = 0;
    for(long t : tree) cnt += Math.max(0, t-len);
    return cnt;
  }

}
