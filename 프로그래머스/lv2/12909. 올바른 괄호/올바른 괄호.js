function solution(s){
    const arr = [];
    const str = s.split('');
    for ( const el of str) {
        if (el==='(') arr.push(el)
        else {
            if (arr.length) arr.pop();
            else {
                arr.push(el);
                break;
            }
        }
    }
    return !arr.length;
}