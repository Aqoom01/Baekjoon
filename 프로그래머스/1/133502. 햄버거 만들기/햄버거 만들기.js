function solution(ingredient) {
    var answer = 0;
    var stack = [];
    
    for(let i of ingredient) {
        //console.log("push" + i);
        if(i === 1) {
            stack.push(i);
            if(stack.length < 4) continue;
            else {
                let check = "" + stack[stack.length - 4] + stack[stack.length - 3] + stack[stack.length - 2] + stack[stack.length - 1];
                if(check === "1231") {
                    answer++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }
        else {
            stack.push(i);
        }
        //console.log("now stack: " + stack);
    }
    
    return answer;
}