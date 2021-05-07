
let subsets = function(nums) {

    let discovered = [];
    let subset = [[]];

    function rec(cur) {
        for(let i = cur; i < nums.length; i++) {
            if(!discovered.includes(nums[i])) {
                discovered.push(nums[i]);
                subset.push([...discovered]);
                rec(i + 1);
                discovered.pop();
            }
        }
    }

    rec(0);

    return subset;
}

let nums = [1,2,3];
let subset = subsets(nums);