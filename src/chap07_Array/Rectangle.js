
function solution(v) {
    let answer = [];

    let x = v.map(a => a[0]);
    let y = v.map(a => a[1]);

    let left = Math.min(...x);
    let right = Math.max(...x);
    let bottom = Math.min(...y);
    let top = Math.max(...y);

    let candidates = [];

    candidates.push([left, top], [left, bottom], [right, top], [right, bottom]);

    candidates.forEach(c => {
        if(!v.some(d => d[0] === c[0] && d[1] === c[1])){
            answer = c;
        }
    });

    return answer;
}


let point = [[1, 4], [3, 4], [3, 10]];

solution(point);