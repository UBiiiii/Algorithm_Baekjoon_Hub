function solution(n) {
    var answer = n;
    let cnt = n.toString(2).split("").filter(el=>el==='1').length;
    while(1) {
        let num = ++answer;
        if(cnt == num.toString(2).split("").filter(el=>el==='1').length)    return answer;
    }
}