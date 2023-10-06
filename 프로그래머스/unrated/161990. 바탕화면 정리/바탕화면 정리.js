const solution = (wallpaper) => wallpaper.map((v, i)=>{
        return [i, [...v].reduce((acc,curr,i)=>{
            if(curr=='#')   acc.push(i);
            return acc;
        }, [])];
    }).filter(el=>el[1].length>0).reduce((acc,curr)=>{
        acc[0] = Math.min(curr[0], acc[0]);
        acc[2] = Math.max(curr[0]+1, acc[2]);
        curr[1].forEach(el=>{
            acc[1] = Math.min(el, acc[1]);
            acc[3] = Math.max(el+1, acc[3]);
        })
        
        return acc;
    }, [wallpaper.length, wallpaper[0].length, 0, 0])