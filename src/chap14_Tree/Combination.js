let combine = function (n, k) {
    let combinations = [];
    let discovered = [];

    function rec(num) {
        for(let i = num; i <= n; i++) {
            if(!discovered.includes(i)) {
                discovered.push(i);
                if(discovered.length === k) {
                    console.log(discovered);
                    combinations.push([...discovered]);
                }
                rec(i + 1);
                discovered.pop();
            }
        }
    }
    rec(1);

    return combinations;
};

let n = 5;
let k = 3;

let com = combine(n, k);