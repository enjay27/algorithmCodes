
let log = ["dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"];

log.sort((a, b) => {
    let as = a.split(" ");
    let bs = b.split(" ");
    let asdigit = as[1].split("").every(x => Number.isInteger(Number.parseInt(x)));
    let bsdigit = bs[1].split("").every(x => Number.isInteger(Number.parseInt(x)));
    if (bsdigit) {
        return 1;
    } else if(!asdigit && !bsdigit) {
        for (let i = 1; i < bs.length; i++) {
            if(i === as.length)
                return 1;
            console.log(as[i]);
            console.log(bs[i]);
            let asc = as[i].split("");
            let bsc = bs[i].split("");
            for (let j = 0; j < bsc.length; j++) {
                console.log(asc[j]);
                console.log(bsc[j]);
                if(j === asc.length)
                    return 1;
                if(bsc[j] > asc[j]) {
                    console.log(true);
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    } else if(asdigit && !bsdigit)
        return -1;

    return 1;
});

console.log(log);

let a = "abc".split("");
let b = "cde".split("");

console.log(a[0] > b[0]);
console.log("a" > "b");
console.log("c" > "a");