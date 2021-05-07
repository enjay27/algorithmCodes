

/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
let isIsomorphic = function(s, t) {

    let s_to_t = new Map();
    let t_to_s = new Map();

    for (let i = 0; i < s.length; i++) {
        let sc = s.charAt(i);
        let tc = t.charAt(i);
        if(s_to_t.has(sc)) {
            if(s_to_t.get(sc) !== tc)  {
                return false;
            }
        } else if(t_to_s.has(tc)){
            if(t_to_s.get(tc) !== sc) {
                return false;
            }
        } else {
            s_to_t.set(sc, tc);
            t_to_s.set(tc, sc);
        }
    }

    return true;
};


let s = "egg", t = "add"
console.log(isIsomorphic(s, t));

let s2 = "foo", t2 = "bar"
console.log(isIsomorphic(s2, t2));

let s3 = "badc", t3 = "baba";
console.log(isIsomorphic(s3, t3));