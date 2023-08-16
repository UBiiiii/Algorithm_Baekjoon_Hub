import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int qp = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int p : priorities) {
            pq.offer(p);
        }

        while(true) {
            if(pq.peek()==priorities[qp]) {
                answer++;
                if(location==qp) break;
                priorities[qp] = -1;
                pq.poll();
            }
            qp = (qp+1)%priorities.length;
        }
        return answer;
    }
}