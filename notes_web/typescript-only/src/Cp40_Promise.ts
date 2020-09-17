/**
 * method 1:
 */
let p= new Promise((resolve, reject) => {
    let statement = true;
    if (statement) {
        resolve('2');
    } else {
        reject('1');
    }
});
p.then((message) => {
    console.log('resolve msg:' + message);
}).catch((message) => {
    console.log('reject msg:' + message);
})

/**
 * method 2
 */
let p1 = new Promise((resolve, reject) => {
    resolve("p1 resolved");
});

let p2 = new Promise((resolve, reject) => {
    resolve("p2 resolved");
});

let p3 = new Promise((resolve, reject) => {
    reject("p3 rejected");
});

export function run() {
    Promise.all([p1, p2, p3]).then(value => console.log(value));
}

run();
    