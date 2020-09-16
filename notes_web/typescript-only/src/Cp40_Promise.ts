let p = new Promise((resolve, reject) => {
    let a = 1 + 1;
    if (a == 2) {
        resolve('2');
    }
    else {
        reject('1');
    }
});

p.then((message) => {
    console.log('resolve msg:' + message);
}).catch((message) => {
    console.log('reject msg:' + message);
})

console.log(p);