/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @param {number[]} nums3
 * @param {number[]} nums4
 * @return {number}
 */
let fourSumCount = function(nums1, nums2, nums3, nums4) {
    let p1 = 0, p2 = 0, p3 = 0, p4 = 0;

    let result = 0;
    let length = nums1.length;
    while(p1 < length) {
        if(nums1[p1] > 0) break;
        if (nums1[p1] + nums2[p2] + nums3[p3] + nums4[p4] === 0) {
            result++;
        } else if(nums1[p1] < nums2[p2] + nums3[p3] + nums4[p4]) {
            p1++;
        } else if(nums1[p1] >= nums2[p2] + nums3[p3] + nums4[p4]) {
            if(p2 < length - 1) {
                if (nums1[p1] + nums2[p2 + 1] + nums3[p3] + nums4[p4] === 0) {
                    result++;
                }
            }
            if(p3 < length - 1) {
                if (nums1[p1] + nums2[p2] + nums3[p3 + 1] + nums4[p4] === 0) {
                    result++;
                }
            }
            if(p4 < length - 1) {
                if (nums1[p1] + nums2[p2] + nums3[p3] + nums4[p4 + 1] === 0) {
                    result++;
                }
            }
            if(p2 < length - 1 && p3 < length - 1) {
                if (nums1[p1] + nums2[p2 + 1] + nums3[p3 + 1] + nums4[p4] === 0) {
                    result++;
                }
            }
            if(p2 < length - 1 && p4 < length - 1) {
                if (nums1[p1] + nums2[p2 + 1] + nums3[p3] + nums4[p4 + 1] === 0) {
                    result++;
                }
            }
            if(p3 < length - 1 && p4 < length - 1) {
                if (nums1[p1] + nums2[p2] + nums3[p3 + 1] + nums4[p4 + 1] === 0) {
                    result++;
                }
            }
            if(p2 < length - 1 && p3 < length - 1 && p4 < length - 1) {
                if (nums1[p1] + nums2[p2 + 1] + nums3[p3 + 1] + nums4[p4 + 1] === 0) {
                    result++;
                }
            }

            if(p2 < length - 1 && p3 < length - 1 && p4 === length - 1) {
                if(nums2[p2 + 1] < nums3[p3 + 1])
                    p2++;
                else
                    p3++;
            } else if(p4 < length - 1 && p3 < length - 1 && p2 === length - 1) {
                if(nums2[p3 + 1] < nums3[p4 + 1])
                    p3++;
                else
                    p4++;
            } else if(p2 < length - 1 && p4 < length - 1 && p3 === length - 1) {
                if(nums2[p2 + 1] < nums3[p4 + 1])
                    p2++;
                else
                    p4++;
            }
            else if(p2 < length - 1 && p3 < length - 1 && p4 < length - 1) {
                if (nums2[p2 + 1] < nums3[p3 + 1] && nums2[p2 + 1] < nums4[p4 + 1])
                    p2++;
                else if (nums3[p3 + 1] < nums2[p2 + 1] && nums3[p3 + 1] < nums4[p4 + 1])
                    p3++;
                else if (nums4[p4 + 1] < nums3[p3 + 1] && nums4[p4 + 1] < nums2[p2 + 1])
                    p4++;
            }
        }
    }

    p1 = length - 1;
    p2 = length - 1;
    p3 = length - 1;
    p4 = length - 1;

    while(p1 >= 0) {
        if(nums1[p1] < 0) break;
        if (nums1[p1] + nums2[p2] + nums3[p3] + nums4[p4] === 0) {
            result++;
        } else {
            if(p2 > 0) {
                if (nums1[p1] + nums2[p2 - 1] + nums3[p3] + nums4[p4] === 0) {
                    result++;
                }
            }
            if(p3 > 0) {
                if (nums1[p1] + nums2[p2] + nums3[p3 - 1] + nums4[p4] === 0) {
                    result++;
                }
            }
            if(p4 > 0) {
                if (nums1[p1] + nums2[p2] + nums3[p3] + nums4[p4 - 1] === 0) {
                    result++;
                }
            }
            if(p2 > 0 && p3 > 0) {
                if (nums1[p1] + nums2[p2 - 1] + nums3[p3 - 1] + nums4[p4] === 0) {
                    result++;
                }
            }
            if(p2 > 0 && p4 > 0) {
                if (nums1[p1] + nums2[p2 - 1] + nums3[p3] + nums4[p4 - 1] === 0) {
                    result++;
                }
            }
            if(p3 > 0 && p4 > 0) {
                if (nums1[p1] + nums2[p2] + nums3[p3 - 1] + nums4[p4 - 1] === 0) {
                    result++;
                }
            }
            if(p2 > 0 && p3 > 0 && p4 > 0) {
                if (nums1[p1] + nums2[p2 - 1] + nums3[p3 - 1] + nums4[p4 - 1] === 0) {
                    result++;
                }
            }

            if(p1 > 0 && nums1[p1 - 1] < Math.min(nums2[p2 - 1], nums3[p3 - 1], nums4[p4 - 1])){
                p1--;
            }
            if(p2 > 0 && p3 > 0 && p4 === 0) {
                if(nums2[p2 - 1] < nums3[p3 - 1])
                    p2--;
                else
                    p3--;
            } else if(p4 > 0 && p3 > 0 && p2 === 0) {
                if(nums2[p3 + 1] < nums3[p4 + 1])
                    p3--;
                else
                    p4--;
            } else if(p2 > 0 && p4 > 0 && p3 === 0) {
                if(nums2[p2 + 1] < nums3[p4 + 1])
                    p2--;
                else
                    p4--;
            }
            else if(p2 > 0 && p3 > 0 && p4 > 0) {
                if (nums2[p2 - 1] < nums3[p3 - 1] && nums2[p2 - 1] < nums4[p4 - 1])
                    p2--;
                else if (nums3[p3 - 1] < nums2[p2 - 1] && nums3[p3 - 1] < nums4[p4 - 1])
                    p3--;
                else if (nums4[p4 - 1] < nums3[p3 - 1] && nums4[p4 - 1] < nums2[p2 - 1])
                    p4--;
            }
        }
    }

    return result;

};


let nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2];

console.log(fourSumCount(nums1, nums2, nums3, nums4));