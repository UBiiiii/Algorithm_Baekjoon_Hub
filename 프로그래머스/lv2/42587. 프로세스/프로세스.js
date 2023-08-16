function solution(priorities, location) {
    var answer = 0;
    let print = 0;
    while (true) {
        let task = priorities.shift();
        let most = true;
        priorities.forEach(el=>{
            if(el>task) most = false;
        });
        if(most) {
            answer++;
            if(location===0) break;
            else location--;
        } else {
            priorities.push(task);
            if (location===0) location=priorities.length-1;
            else location--;
        }
    }
    return answer;
}