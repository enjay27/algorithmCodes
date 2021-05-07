
let dfs = function(graph, start, discovered) {
    discovered.push(start);
    for(let i of graph.get(start)) {
        if(!discovered.includes(i)) {
            discovered = dfs(graph, i, discovered);
            console.log(i);
        }
    }
    return discovered;
}

let graph = new Map();

graph.set(1, [2,3,4]);
graph.set(2, [5]);
graph.set(3, [5]);
graph.set(4, []);
graph.set(5, [6,7]);
graph.set(6, []);
graph.set(7, [3]);

let dis = [];
dfs(graph, 1, dis);


let bfs = function(graph, start) {
    let discovered = [start];
    let queue = [start];
    while(queue.length > 0) {
        let v = queue.shift();
        for(let w of graph.get(v)) {
            if(!discovered.includes(w)) {
                discovered.push(w);
                queue.push(w);
            }
        }
    }
    return discovered;
}

let disc = bfs(graph, 1);