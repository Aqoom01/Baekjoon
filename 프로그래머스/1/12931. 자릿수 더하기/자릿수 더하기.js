function solution(n)
{
    n = String(n);
    var answer = 0;
    for(let i = 0; i < n.length; i++) answer += parseInt(n.charAt(i));
    return answer;
}