import java.util.Arrays;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int sp=0, ep=1, tmp=0;
        int[] answer = new int[] {0, sequence.length};
        int[] sum = new int[sequence.length + 1];
        for(int i=0;i<sequence.length;i++)  sum[i+1] = sum[i] + sequence[i];
        while(!(sp>sequence.length || ep>sequence.length)) {
            if(sp>ep)  ep++;
            else {
                tmp = sum[ep] - sum[sp];
                if(tmp==k) {
                    answer = (ep-1) - sp < answer[1] - answer[0] ? new int[] {sp, ep-1} : answer;
                    ep++;
                }
                else if(tmp < k)    ep++;
                else                sp++;
            }
        }
        return answer;
    }
}