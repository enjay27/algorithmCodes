let swapPairs = function(head) {
    if (head !== null && head.next !== null) {
        let p = head.next;

        head.next = swapPairs(p.next);
        p.next = head;
        return p;
    }
    return head;
}

class Node {
    constructor(node, value) {
        this.next = node;
        this.val = value;
    }
}

let n6 = new Node(null, 6);
let n5 = new Node(n6, 5);
let n4 = new Node(n5, 4);
let n3 = new Node(n4, 3);
let n2 = new Node(n3, 2);
let n1 = new Node(n2, 1);

let swap = swapPairs(n1);
