function solution(today, terms, privacies) {
    const term = terms.map(el=>el.split(" ")).reduce((acc,curr)=>{
        acc[curr[0]] = curr[1]-'0';
        return acc;
    }, {});
    
    today = new Date(today);
    
    return privacies.map(el=>{
        const curr = el.split(" ");
        const date = new Date(curr[0]);
        
        date.setMonth(date.getMonth()+term[curr[1]]);
        return date;
    }).reduce((acc,curr,i)=>{
        if(today.valueOf() >= curr.valueOf())    acc.push(i+1);
        return acc;
    }, [])
}