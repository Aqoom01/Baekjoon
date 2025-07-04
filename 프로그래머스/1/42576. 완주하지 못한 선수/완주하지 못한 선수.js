function solution(participant, completion) {
    let names = new Map();
    var answer = "";
    
    for(const part of participant) {
        let count = names.get(part);
        if(count !== undefined) {
            names.set(part, count + 1);
        }
        else {
            names.set(part, 1);
        }
    }
    
    for(const comp of completion) {
        let count = names.get(comp);
        if(count !== undefined) {
            let newCount = count - 1;
            if(newCount === 0) {
                names.delete(comp);
            }
            else {
                names.set(comp, newCount);
            }
        }
        else {
            answer = comp;
            break;
        }
    }
    
    if(answer === "") {
        let keys = names.keys();
        for(const key of keys) answer = key;
    }
    return answer;
}