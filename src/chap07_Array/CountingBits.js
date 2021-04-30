
let countBits = function(num) {
    let ret = [];

    for(let i = 0; i <= num; i++) {
        let bit = i.toString(2);
        console.log(bit);
        let count = 0;
        for(let j = 0; j < bit.length; j++) {
            if(bit.charAt(j) === "1"){
                count++;
            }
        }
        ret.push(count);
    }

    return ret;
};

console.log(countBits(5));