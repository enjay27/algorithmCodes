
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
let isSymmetric = function(root) {

    if(root.left != null && root.right == null)
        return false;
    else if(root.left == null && root.right != null)
        return false;

    let stack = [];
    let result = true;

    function left(tree) {
        if(tree == null) {
            stack.push(null);
            return;
        }

        stack.push(tree.val);
        if(tree.left == null && tree.right == null)
            return;
        if(tree.left == null) {
            stack.push(null);
        } else {
            left(tree.left);
        }
        if(tree.right == null) {
            stack.push(null);
        } else {
            left(tree.right);
        }
    }

    left(root.left);
    console.log(stack);

    let stack2 = [];

    function right(tree) {
        if(tree == null) {
            stack2.push("tree is null");
            if(stack.pop() != null) {
                result = false;
            }
            return;
        }

        // right(tree.left);
        // right(tree.right);
        if(tree.left == null && tree.right == null) {
            stack2.push(tree.val);
            if(stack.pop() !== tree.val) {
                result = false;
            }
            return;
        }
        if(tree.left == null) {
            stack2.push("left is null");
            if(stack.pop() != null) {
                result = false;
            }
        } else {
            right(tree.left);
        }
        if(tree.right == null) {
            stack2.push("right is null");
            if(stack.pop() != null) {
                result = false;
            }
        } else {
            right(tree.right);
        }

        stack2.push(tree.val);
        if(stack.pop() !== tree.val) {
            result = false;
        }
    }

    right(root.right);
    console.log(stack2);

    return result;
};

function TreeNode(val, left, right) {
    this.val = (val===undefined ? 0 : val)
    this.left = (left===undefined ? null : left)
    this.right = (right===undefined ? null : right)
}



let right1_r = new TreeNode(3);
// let right1_l = new TreeNode(4);
let left1_r = new TreeNode(3);
// let left1_l = new TreeNode(3);
let right1 = new TreeNode(2, null, right1_r);
let left1 = new TreeNode(2, null, left1_r);
let root = new TreeNode(1, left1, right1);

console.log(isSymmetric(root));

let right1_r2 = new TreeNode(3);
let right1_l2 = new TreeNode(4);
let left1_r2 = new TreeNode(4);
let left1_l2 = new TreeNode(3);
let right12 = new TreeNode(2, right1_l2, right1_r2);
let left12 = new TreeNode(2, left1_l2, left1_r2);
let root2 = new TreeNode(1, left12, right12);

console.log(isSymmetric(root2));

let right3 = new TreeNode(2, null, null);
let left3 = new TreeNode(3, null, null);
let root3 = new TreeNode(1, left3, right3);

console.log(isSymmetric(root3));
