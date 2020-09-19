//Q: how to write this in typescript?
export function Tree(name) {
  this.name = name;
}
let theTree = new Tree('Redwood');
console.log('theTree.constructor is ' + theTree.constructor)
console.log('theTree.name is ' + theTree.name)
//-----------------------
"use strict";
function f(fn) {
    function p2(self, fn) {
        return new self.constructor(fn);
    }
    var o2 = p2(this, function () { return console.log("p.p2.fn"); });
    console.log(o2);
}
f("1");
