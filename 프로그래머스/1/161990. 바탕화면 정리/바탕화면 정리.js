function solution(wallpaper) {
    let positions = [];
    
    for(let i = 0; i < wallpaper.length; i++) {
        for(let j = 0; j < wallpaper[i].length; j++) {
            if(wallpaper[i][j] == '#') {
                let position = {x: i, y: j};
                positions.push(position);
            }
        }
    }
    
    let lux = 51;
    let luy = 51;
    let rdx = 0;
    let rdy = 0;
    for(const position of positions) {
        if(position.x < lux) lux = position.x;
        if(position.x + 1 > rdx) rdx = position.x + 1;
        if(position.y < luy) luy = position.y;
        if(position.y + 1 > rdy) rdy = position.y + 1;
    }
    
    return [lux, luy, rdx, rdy];
}