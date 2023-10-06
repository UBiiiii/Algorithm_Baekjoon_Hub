function solution(lottos, win_nums) {
    const cnt = lottos.map(el=>el!=0 ? (win_nums.includes(el) ? 1 : -1) : 0).reduce((acc,curr)=>{
        acc[0] += curr==1;
        acc[1] += curr==0;
        return acc;
    }, [0, 0]);
    
    return [Math.min(7-cnt[0]-cnt[1], 6), Math.min(7-cnt[0], 6)];
}