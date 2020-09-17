
export function f(fn:any) {
    // function p2(self:any, fn:any){
    //     return new self.constructor(fn);
    // }
    // var o2 = p2(this,()=>console.log("p.p2.fn"))
    console.log(this.constructor)
}
f("1");
