import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int tmp = 0, i = numbers.length - 1, num = 0;
        Stack<Integer> s = new Stack<>();
        int[] answer = new int[numbers.length];
        answer[i] = -1;
        s.push(numbers[i--]);
        for(;i>-1;i--) {
            num = numbers[i];
            while(!s.isEmpty() && s.peek() <= num)    s.pop();
            answer[i] = s.isEmpty() ? -1 : s.peek();
            s.push(num);
        }
        
        return answer;
    }
}