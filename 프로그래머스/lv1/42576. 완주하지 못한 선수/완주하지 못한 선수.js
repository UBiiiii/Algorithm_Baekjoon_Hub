function solution(participant, completion) {
    let answer = '';
    
    let people = {};
    for(const p of participant) {
        people[p] = people[p]!=undefined ? people[p]+1 : 1;
    }
    
    for(const c of completion) people[c]--;
    
    for(const p of participant) if(people[p]!=0) {
        answer = p;
        break;
    }
    return answer;
}