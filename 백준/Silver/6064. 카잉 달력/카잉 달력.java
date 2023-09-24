import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine()), bound = 0;
    StringBuffer sb = new StringBuffer();
    int[] input;
    for(int i=0;i<t;i++) {
      input = Arrays.stream(br.readLine().split(" ")).mapToInt(el->Integer.parseInt(el)).toArray();
      bound = input[0]*input[1];
      while(input[2]!=input[3]) {
        if(input[2]>input[3]) input[3]+=input[1];
        else                  input[2]+=input[0];

        if(input[2]>bound || input[3]>bound)  break;
      }

      sb.append(input[2]==input[3] ? input[2] : -1).append(i!=t-1 ? "\n" : "");
    }

    System.out.println(sb.toString());
  }

}
