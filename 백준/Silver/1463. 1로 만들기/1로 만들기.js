const arr = new Array(1000001).fill(-1);

function solve(input) {
    count = 0;
    arr[input] = count;
    let q = [];
    q.push(input);

    while(arr[1] == -1) {
        let cur = q[0];
        count = arr[cur] + 1;
        
        q = q.slice(1);
        if(arr[cur - 1] == -1) {
            arr[cur - 1] = count;
            q.push(cur - 1);
        }
        
        if(cur % 2 == 0 && arr[cur / 2] == -1) {
            arr[cur / 2] = count;
            q.push(cur / 2);
        }

        if(cur % 3 == 0 && arr[cur / 3] == -1) {
            arr[cur / 3] = count;
            q.push(cur / 3);
        }
    }

    return arr[1];
}

const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question('', function(answer) {
    console.log(solve(answer));
    rl.close();
});