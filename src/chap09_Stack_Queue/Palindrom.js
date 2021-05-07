let isPalind = function(str) {
    if(str === null)
        return false;

    let isEng = /[a-zA-Z]/;

    let stack = [];

    for (let i = 0; i < str.length; i++) {
        if(isEng.test(str.charAt(i))) {
            stack.push(str.charAt(i).toLowerCase());
        }
    }

    let length = 0;

    while (length < stack.length - 1) {
        if (stack.pop() !== stack[length]) {
            return false;
        }
        length++;
    }
    return true;
}

let str = "A man, a plan, a canal: Panama";

isPalind(str);