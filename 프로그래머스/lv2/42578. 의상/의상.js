function solution(clothes) {
    var answer = 1;
    const closet = new Map();
    clothes.forEach(el=>{
        closet.set(el[1], closet.get(el[1])==undefined ? 1 : closet.get(el[1])+1);
    })
    
    const keys = [...closet.keys()];
    keys.forEach(key=>{
        answer *= closet.get(key)+1;
    })
    
    
    return answer-1;
}