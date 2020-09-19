export function Tree(name) {
  this.name = name;
}

// class Tree {
//   constructor(name) {
//     this.name = name;
//     t = this;
//   }
// }

let theTree = new Tree('Redwood');
console.log('theTree.constructor is ' + theTree.constructor)
console.log('theTree.name is ' + theTree.name)
//Q: how to write this in typescript...