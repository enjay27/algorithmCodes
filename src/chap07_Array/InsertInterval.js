/**
 * @param {number[][]} intervals
 * @param {number[]} newInterval
 * @return {number[][]}
 */
let insert = function(intervals, newInterval) {

    if(intervals.length !== 0) {
        if (intervals[intervals.length - 1][1] < newInterval[0]) {
            intervals.push(newInterval);
            return intervals;
        } else if (intervals[0][0] > newInterval[1]) {
            intervals.unshift(newInterval);
            return intervals;
        }
    } else {
        return [newInterval];
    }

    let start = findSmallest(intervals, newInterval[0]);
    let end = findBiggest(intervals, newInterval[1]);
-
    console.log(start);
    console.log(end);

    if(start < 0) start = 0;
    if(end >= intervals.length) end = intervals.length - 1;
    if(end < 0) end = 0;

    console.log(start);
    console.log(end);

    if(intervals[start][1] < newInterval[0]) {
        start++;
    }
    if(intervals[end][0] > newInterval[1]) {
        end--;
    }

    if(start > end) start = end;

    console.log(start);
    console.log(end);

    if(start === end) {
        if(newInterval[0] < intervals[start][0]) {
            intervals[start][0] = newInterval[0]
        }
        if(newInterval[1] > intervals[start][1]) {
            intervals[start][1] = newInterval[1];
        }
    } else {
        let starts = intervals[start];
        let ends = intervals[end];
        intervals.splice(start, end - start + 1, [Math.min(starts[0], newInterval[0]), Math.max(ends[1], newInterval[1])]);
    }


    return intervals;
};


function findSmallest(sortedArray, seekElement) {
    let startIndex = 0;
    let endIndex = sortedArray.length - 1;

    while (startIndex <= endIndex) {
        const middleIndex = startIndex + Math.floor((endIndex - startIndex) / 2);
        if (sortedArray[middleIndex][0] === seekElement) {
            return middleIndex;
        }
        if (sortedArray[middleIndex][0] < seekElement) {
            startIndex = middleIndex + 1;
        } else {
            endIndex = middleIndex - 1;
        }
    }

    return endIndex;
}

function findBiggest(sortedArray, seekElement) {
    let startIndex = 0;
    let endIndex = sortedArray.length - 1;

    while (startIndex <= endIndex) {
        const middleIndex = startIndex + Math.floor((endIndex - startIndex) / 2);
        if (sortedArray[middleIndex][1] === seekElement) {
            return middleIndex;
        }
        if (sortedArray[middleIndex][1] < seekElement) {
            startIndex = middleIndex + 1;
        } else {
            endIndex = middleIndex - 1;
        }
    }

    return startIndex;
}



let intervals = [[1,3],[6,9]], newInterval = [2,5]
console.log(insert(intervals, newInterval));

let intervals2 = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval2 = [4,8]
console.log(insert(intervals2, newInterval2));

let intervals3 = [], newInterval3 = [5,7];
console.log(insert(intervals3, newInterval3));

let intervals4 = [[1,5]], newInterval4 = [6,8];
console.log(insert(intervals4, newInterval4));

let intervals5 = [[1,5],[6,8]], newInterval5 = [0,9];
console.log(insert(intervals5, newInterval5));

let intervals6 = [[0,5],[8,9]], newInterval6 = [3,4];
console.log(insert(intervals6, newInterval6));

