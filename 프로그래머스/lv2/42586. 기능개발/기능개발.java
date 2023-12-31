import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> task = new LinkedList<>();
        int sp = 0, cnt = 0;
        while(sp<progresses.length) {
            cnt = 0;
            for(int i=sp;i<progresses.length; i++) {
                progresses[i] += speeds[i];
            }
            while(sp<progresses.length && progresses[sp] >= 100) {
                cnt++;
                sp++;
            }
            if(cnt>0)   task.offer(cnt);
        }
        answer = new int[task.size()];
        for(int i=0;i<answer.length; i++) {
            answer[i] = task.poll();
        }
        
        return answer;
    }
}