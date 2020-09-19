const Tree: any = function (this: any, name: string) {
  this.name = name;
}
let aTree = new Tree("Redwood");
console.log('theTree.constructor is ' + aTree.constructor);

// let notTree = {
//   name: "river",
// }
// let notATree = new Tree(notTree, "River");
// console.log('theTree.constructor is ' + notATree.constructor);

export { Tree };