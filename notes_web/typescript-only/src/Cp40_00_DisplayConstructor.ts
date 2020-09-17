function Tree(this: typeof Tree, name:string) {
  this.name = name;
}

let theTree = new Tree(globalThis, "Redwood");
console.log('theTree.constructor is ' + theTree.constructor)
//Q: how to write this in typescript...