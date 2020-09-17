"use strict";
function f(fn) {
    function p2(self, fn) {
        return new self.constructor(fn);
    }
    var o2 = p2(this, function () { return console.log("p.p2.fn"); });
    console.log(o2);
}
f("1");
