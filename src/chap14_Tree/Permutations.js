let permute = function (nums) {

    let permutations = [];
    let discovered = [];

    function rec(disc) {
        for(let num of nums) {
            if(!disc.includes(num)) {
                disc.push(num);
                console.log(disc);
                if(disc.length === nums.length) {
                    console.log("push");
                    console.log(disc);
                    permutations.push([...disc]);
                }
                rec(disc);
                disc.pop();
            }
        }
        return disc;
    }

    rec(discovered);

    return permutations;
};

let nums = [1,2,3];
let p = permute(nums);