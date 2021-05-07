
let mergeSort = function(arr) {

    function merge(a1, a2) {
        let c1 = 0;
        let c2 = 0;
        let merged = [];
        while (c1 < a1.length && c2 < a2.length) {
            if(a1[c1] < a2[c2]) {
                merged.push(a1[c1]);
                c1++;
            } else {
                merged.push(a2[c2]);
                c2++;
            }
        }
        if (c1 < a1.length) {
            merged.push(...a1.slice(c1));
        } else if(c2 < a2.length) {
            merged.push(...a2.slice(c2));
        }

        return merged;
    }

    if(arr.length === 1) {
        return arr;
    } else {
        let m1 = mergeSort(arr.slice(0, arr.length/2));
        let m2 = mergeSort(arr.slice(arr.length/2));
        return merge(m1, m2);
    }
}

let arr = [6, 1, 5, 8, 2, 7, 9, 3, 4];

console.log(mergeSort(arr));
