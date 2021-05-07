
let combinationSum = function(candidates, target) {
    let combinations = [];
    let discovered = [];

    function rec(cur) {
        for(let i = cur; i < candidates.length; i++) {
            discovered.push(candidates[i]);
            let sum = discovered.reduce((a, b) => a + b);
            if(sum === target) {
                combinations.push([...discovered]);
            } else if(sum > target) {
                discovered.pop();
                return;
            }
            rec(i);
            discovered.pop();
        }
    }

    rec(0);

    return combinations;
}

let candidates = [2, 3, 6, 7];
let target = 7;

let combinations = combinationSum(candidates, target);